package bridge.utils.input;

import bridge.constant.ExceptionMessage;
import bridge.factory.ViewFactory;

public class BridgeSizeInput {
    private BridgeSizeInput() {

    }

    public static int inputBridgeSize() {
        while (true) {
            try {
                return ViewFactory.getInputView().readBridgeSize();
            } catch (IllegalArgumentException exception) {
                ViewFactory.getOutputView().printErrorMessage(ExceptionMessage.BRIDGE_RANGE.getMessage());
            }
        }
    }
}
