package experiment.app.graphics;

public interface Renderer {
    public void setColor(int color);
    public void setFont(String fontName, int size);
    public void setRotation(double theta, double x, double y);
    public void fillRect(double left, double top, double width, double height);
    public void drawString(String string, int left, int top);
    public void flush();
}
