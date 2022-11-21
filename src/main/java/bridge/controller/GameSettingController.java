package bridge.controller;

import bridge.factory.ViewFactory;
import bridge.model.Bridge;
import bridge.model.BridgeGameResult;
import bridge.BridgeMaker;
import bridge.utils.BridgeNumberGenerator;
import bridge.utils.input.BridgeSizeInput;

public class GameSettingController {
    public Bridge generateBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        ViewFactory.getOutputView().printBridgeGameStart();
        int bridgeSize = BridgeSizeInput.inputBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public BridgeGameResult initGameResult(int bridgeSize) {
        return new BridgeGameResult(bridgeSize);
    }
}
