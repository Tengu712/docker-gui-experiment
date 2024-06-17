package experiment.app.input;

public interface InputListener {
    public int getInputState(InputType type);
    public void update();
}
