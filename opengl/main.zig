const gl = @cImport(@cInclude("GL/gl.h"));
const glfw = @cImport(@cInclude("GLFW/glfw3.h"));
const std = @import("std");
const stdout = std.io.getStdOut().writer();
const window_width = 640;
const window_height = 480;

pub fn main() !void {
    if (glfw.glfwInit() != glfw.GLFW_TRUE) {
        try stdout.print("[ error ] main(): failed to init GLFW.\n", .{});
    }
    defer glfw.glfwTerminate();

    const window = glfw.glfwCreateWindow(window_width, window_height, "Docker GUI Experiment: openGL", null, null);
    if (window == null) {
        try stdout.print("[ error ] main(): failed to create a window.\n", .{});
    }
    glfw.glfwMakeContextCurrent(window);

    try stdout.print("[ info ] main(): GLFW version = {s}\n", .{glfw.glfwGetVersionString()});
    try stdout.print("[ info ] main(): OpenGL version = {s}\n", .{gl.glGetString(gl.GL_VERSION)});
    try stdout.print("[ info ] main(): Vender name = {s}\n", .{gl.glGetString(gl.GL_VENDOR)});
    try stdout.print("[ info ] main(): GPU name = {s}\n", .{gl.glGetString(gl.GL_RENDERER)});

    glfw.glfwSwapInterval(1);
    glfw.glClearColor(0.1, 0.1, 0.1, 1.0);

    var count: u32 = 0;
    var start = std.time.milliTimestamp();
    while (glfw.glfwWindowShouldClose(window) != glfw.GLFW_TRUE) {
        const end = std.time.milliTimestamp();
        const dis = end - start;
        if (dis >= 1000) {
            const count_f32 = @as(f32, @floatFromInt(count));
            const dis_f32 = @as(f32, @floatFromInt(dis));
            const fps = count_f32 / dis_f32 * 1000.0;
            count = 0;
            start = end;
            try stdout.print("[ debug ] main(): {} fps.\n", .{fps});
        }
        count += 1;

        gl.glViewport(0, 0, window_width, window_height);
        gl.glClear(gl.GL_COLOR_BUFFER_BIT);

        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex2f(0.0, 0.5);
        gl.glVertex2f(-0.5, -0.5);
        gl.glVertex2f(0.5, -0.5);
        gl.glEnd();

        glfw.glfwSwapBuffers(window);
        glfw.glfwPollEvents();
    }
}
