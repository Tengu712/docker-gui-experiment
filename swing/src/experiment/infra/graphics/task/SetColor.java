package experiment.infra.graphics.task;

import java.awt.Color;
import java.awt.Graphics2D;

public class SetColor implements Task {
    private final int color;

    public SetColor(int color) {
        this.color = color;
    }

    public void run(Graphics2D g) {
        g.setColor(new Color(this.color, true));
    }
}
