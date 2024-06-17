package experiment.infra.graphics.task;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class SetRotation implements Task {
    private final double theta;
    private final double x;
    private final double y;

    public SetRotation(double theta, double x, double y) {
        this.theta = theta;
        this.x = x;
        this.y = y;
    }

    public void run(Graphics2D g) {
        AffineTransform transform = new AffineTransform();
        transform.setToRotation(this.theta, this.x, this.y);
        g.setTransform(transform);
    }
}
