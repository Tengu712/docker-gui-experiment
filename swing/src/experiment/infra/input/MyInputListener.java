package experiment.infra.input;

import experiment.app.input.InputListener;
import experiment.app.input.InputType;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.HashMap;

public class MyInputListener implements InputListener, KeyListener {
    private final Map<InputType, Boolean> pressedStates;
    private final Map<InputType, Integer> countStates;

    public MyInputListener() {
        this.pressedStates = new HashMap<>();
        this.countStates = new HashMap<>();
    }

    public int getInputState(InputType type) {
        synchronized(this.countStates) {
            if (this.countStates.containsKey(type)) {
                return this.countStates.get(type);
            } else {
                return 0;
            }
        }
    }

    public void update() {
        synchronized(this.pressedStates) {
            synchronized(this.countStates) {
                for (Map.Entry<InputType, Boolean> entry: this.pressedStates.entrySet()) {
                    InputType key = entry.getKey();
                    if (entry.getValue()) {
                        if (this.countStates.containsKey(key)) {
                            this.countStates.put(key, this.countStates.get(key) + 1);
                        } else {
                            this.countStates.put(key, 1);
                        }
                    } else {
                        this.countStates.put(key, 0);
                    }
                }
            }
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        synchronized(this.pressedStates) {
            switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                this.pressedStates.put(InputType.ENTER, true);
                break;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        synchronized(this.pressedStates) {
            switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                this.pressedStates.put(InputType.ENTER, false);
                break;
            }
        }
    }
}
