const x11 = @cImport(@cInclude("X11/Xlib.h"));
const std = @import("std");
const stdout = std.io.getStdOut().writer();
const window_width = 640;
const window_height = 480;

fn convertColor(count: u32, max: u32) c_ushort {
    const count_f32 = @as(f32, @floatFromInt(count));
    const max_f32 = @as(f32, @floatFromInt(max));
    const ushort_max_f32 = @as(f32, @floatFromInt(0xffff));
    return @as(c_ushort, @intFromFloat(count_f32 / max_f32 * ushort_max_f32));
}

pub fn main() !void {
    const display = x11.XOpenDisplay(null);
    if (display == null) {
        try stdout.print("[ error ] main(): failed to open a display.\n", .{});
        std.process.exit(1);
    }
    defer _ = x11.XCloseDisplay(display);

    const window = x11.XCreateSimpleWindow(
        display,
        x11.DefaultRootWindow(display),
        0,
        0,
        window_width,
        window_height,
        0,
        0,
        0,
    );
    defer _ = x11.XDestroyWindow(display, window);

    const wm_protocols = x11.XInternAtom(display, "WM_PROTOCOLS", 0);
    var wm_delete_window_atom = x11.XInternAtom(display, "WM_DELETE_WINDOW", 0);
    _ = x11.XSetWMProtocols(display, window, &wm_delete_window_atom, 1);
    _ = x11.XStoreName(display, window, "Docker GUI experiment: Xlib");
    _ = x11.XMapWindow(display, window);
    _ = x11.XFlush(display);

    const gc = x11.XCreateGC(display, x11.DefaultRootWindow(display), 0, null);
    const colormap = x11.DefaultColormap(display, 0);

    var count: u32 = 0;

    mainloop: while (true) {
        while (x11.XPending(display) != 0) {
            var event: x11.XEvent = undefined;
            _ = x11.XNextEvent(display, &event);
            if (event.type == x11.ClientMessage) {
                const is_type_same = event.xclient.message_type == wm_protocols;
                const is_data_same = event.xclient.data.l[0] == wm_delete_window_atom;
                if (is_type_same and is_data_same) {
                    break :mainloop;
                }
            }
        }
        var color = x11.XColor{
            .pixel = 0,
            .red = convertColor(count, 60),
            .green = 0,
            .blue = 0,
            .flags = 0,
            .pad = 0,
        };
        _ = x11.XAllocColor(display, colormap, &color);
        _ = x11.XSetForeground(display, gc, color.pixel);
        _ = x11.XFillRectangle(display, window, gc, 0, 0, window_width, window_height);
        count = (count + 1) % 60;
        std.time.sleep(16666666);
    }
}
