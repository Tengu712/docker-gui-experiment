package experiment.app;

public class FpsMeasure {
    private long start;
    private int count;
    private float fps; 
    
    public FpsMeasure() {
        this.start = System.currentTimeMillis();
        this.count = 0;
        this.fps = 0.0f;
    }

    public void update() {
        long end = System.currentTimeMillis();
        long dis = end - this.start;
        if (dis >= 1000) {
            this.fps = (float)this.count / (float)dis * 1000.0f;
            this.count = 0;
            this.start = end;
        }
        this.count += 1;
    }

    public float get() {
        return this.fps;
    }
}
