package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isPassStep(int index, String playerMoving) {
        return bridge.get(index).equals(playerMoving);
    }
}
