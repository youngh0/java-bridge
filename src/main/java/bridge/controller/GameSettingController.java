package bridge.controller;

import bridge.*;

public class GameSettingController {
    public Bridge generateBridge(InputView inputView, BridgeNumberGenerator bridgeNumberGenerator) {
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
