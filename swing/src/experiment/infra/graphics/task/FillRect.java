package experiment.infra.graphics.task;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class FillRect implements Task {
    private final double left;
    private final double top;
    private final double width;
    private final double height;

    public FillRect(double left, double top, double width, double height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public void run(Graphics2D g) {
        g.fill(new Rectangle2D.Double(this.left, this.top, this.width, this.height));
    }
}
