package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> bridgeInfo;

    public Bridge(List<String> bridgeInfo) {
        this.bridgeInfo = Collections.unmodifiableList(bridgeInfo);
    }

    public boolean isCanMove(String playerMoving, int index) {
        return bridgeInfo.get(index).equals(playerMoving);
    }

    public int getBridgeSize() {
        return bridgeInfo.size();
    }
}
