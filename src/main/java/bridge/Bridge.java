package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int bridgeSize, BridgeMaker bridgeMaker) {
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}
