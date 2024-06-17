package experiment.infra.graphics;

import experiment.app.graphics.Renderer;
import experiment.infra.graphics.task.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyRenderer extends JPanel implements Renderer {
    private final List<Task> tasks;

    public MyRenderer(int width, int height) {
        this.tasks = new ArrayList<>();
        this.setPreferredSize(new Dimension(width, height));
    }

    public void setColor(int color) {
        synchronized(this.tasks) {
            this.tasks.add(new SetColor(color));
        }
    }

    public void setFont(String fontName, int size) {
        synchronized(this.tasks) {
            this.tasks.add(new SetFont(fontName, size));
        }
    }

    public void setRotation(double theta, double x, double y) {
        synchronized(this.tasks) {
            this.tasks.add(new SetRotation(theta, x, y));
        }
    }

    public void fillRect(double left, double top, double width, double height) {
        synchronized(this.tasks) {
            this.tasks.add(new FillRect(left, top, width, height));
        }
    }

    public void drawString(String string, int left, int top) {
        synchronized(this.tasks) {
            this.tasks.add(new DrawString(string, left, top));
        }
    }

    public void flush() {
        synchronized(this.tasks) {
            this.repaint();
        }
    }

    public void paintComponent(Graphics g) {
        synchronized(this.tasks) {
            for (Task task: this.tasks) {
                task.run((Graphics2D)g);
            }
            tasks.clear();
        }
    }
}
