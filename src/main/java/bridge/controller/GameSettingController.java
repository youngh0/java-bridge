package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGameResult;
import bridge.BridgeMaker;
import bridge.utils.BridgeNumberGenerator;
import bridge.view.InputView;

public class GameSettingController {
    public Bridge generateBridge(InputView inputView, BridgeNumberGenerator bridgeNumberGenerator) {
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public BridgeGameResult initGameResult(int bridgeSize) {
        return new BridgeGameResult(bridgeSize);
    }
}
