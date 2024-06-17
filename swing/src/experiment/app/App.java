package experiment.app;

import experiment.app.graphics.Renderer;
import experiment.app.input.InputListener;
import experiment.app.input.InputType;

public class App {
    private static final int[] COLORS = new int[]{0xffff0000, 0xff00ff00, 0xff0000ff};

    private final Renderer renderer;
    private final InputListener inputListener;
    private final FpsMeasure fpsMeasure;
    private int index;
    private int count;

    public App(Renderer renderer, InputListener inputListener) {
        this.renderer = renderer;
        this.inputListener = inputListener;
        this.fpsMeasure = new FpsMeasure();
        this.index = 0;
        this.count = 0;
    }

    public void run() {
        while (true) {
            this.inputListener.update();
            this.fpsMeasure.update();

            if (this.inputListener.getInputState(InputType.ENTER) == 1) {
                this.index = (this.index + 1) % 3;
            }

            // background
            this.renderer.setColor(0xffffffff);
            this.renderer.fillRect(0, 0, 640, 480);
            // rectangle
            this.renderer.setRotation(Math.toRadians((double)this.count * 0.6), 320.0, 240.0);
            this.renderer.setColor(App.COLORS[this.index]);
            this.renderer.fillRect(160.0, 80.0, 320.0, 320.0);
            this.renderer.setRotation(0.0, 0.0, 0.0);
            // guide
            this.renderer.setColor(0xff000000);
            this.renderer.setFont("Arial", 12);
            this.renderer.drawString("Press Enter to change the rectangle color.", 5, 12);
            // fps
            this.renderer.setFont("Arial", 16);
            this.renderer.drawString(String.format("%04.1ffps", this.fpsMeasure.get()), 580, 475);
            // flush
            this.renderer.flush();

            this.count += 1;
            
            try {
                Thread.sleep(16);
            } catch(Exception _error) {
            }
        }
    }
}
