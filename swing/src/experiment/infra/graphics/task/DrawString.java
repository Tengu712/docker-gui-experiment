package experiment.infra.graphics.task;

import java.awt.Graphics2D;

public class DrawString implements Task {
    private final String string;
    private final int left;
    private final int top;

    public DrawString(String string, int left, int top) {
        this.string = string;
        this.left = left;
        this.top = top;
    }

    public void run(Graphics2D g) {
        g.drawString(this.string, this.left, this.top);
    }
}
