package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.constant.ExceptionMessage;
import bridge.model.Bridge;
import bridge.model.BridgeGameResult;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameSettingController {
    private final OutputView outputView = new OutputView();

    public Bridge generateBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        outputView.printBridgeGameStart();
        int bridgeSize = inputBridgeSize(new InputView());
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public BridgeGameResult initGameResult(int bridgeSize) {
        return new BridgeGameResult(bridgeSize);
    }

    private int inputBridgeSize(InputView inputView) {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(ExceptionMessage.BRIDGE_RANGE.getMessage());
            }
        }
    }
}
