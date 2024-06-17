package experiment;

import experiment.app.App;
import experiment.infra.MyFrame;

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame("Docker GUI App Experiment: Swing", 640, 480);
        App app = new App(frame.getRenderer(), frame.getInputListener());
        app.run();
    }
}
