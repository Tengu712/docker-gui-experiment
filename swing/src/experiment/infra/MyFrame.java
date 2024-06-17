package experiment.infra;

import experiment.app.graphics.Renderer;
import experiment.app.input.InputListener;
import experiment.infra.graphics.MyRenderer;
import experiment.infra.input.MyInputListener;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    private final MyRenderer renderer;
    private final MyInputListener inputListener;

    public MyFrame(String title, int width, int height) {
        this.renderer = new MyRenderer(width, height);
        this.inputListener = new MyInputListener();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setResizable(false);
        this.add(this.renderer);
        this.addKeyListener(this.inputListener);
        this.pack();
        this.setVisible(true);
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public InputListener getInputListener() {
        return this.inputListener;
    }
}
