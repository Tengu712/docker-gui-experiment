package experiment.infra.graphics.task;

import java.awt.Font;
import java.awt.Graphics2D;

public class SetFont implements Task {
    private final String fontName;
    private final int size;

    public SetFont(String fontName, int size) {
        this.fontName = fontName;
        this.size = size;
    }

    public void run(Graphics2D g) {
        g.setFont(new Font(this.fontName, Font.PLAIN, this.size));
    }
}
