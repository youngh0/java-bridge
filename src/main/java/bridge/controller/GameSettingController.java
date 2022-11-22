package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.constant.ExceptionMessage;
import bridge.model.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameSettingController {
    public Bridge generateBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        OutputView.getInputView().printBridgeGameStart();
        int bridgeSize = inputBridgeSize(InputView.getInputView());
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private int inputBridgeSize(InputView inputView) {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                OutputView.getInputView().printErrorMessage(ExceptionMessage.BRIDGE_RANGE.getMessage());
            }
        }
    }
}
