package bridge.utils.input;

import bridge.constant.ExceptionMessage;
import bridge.factory.ViewFactory;

public class PlayerMovingInput {
    private PlayerMovingInput() {

    }

    public static String inputPlayerMoving() {
        while (true) {
            try {
                return ViewFactory.getInputView().readMoving();
            } catch (IllegalArgumentException exception) {
                ViewFactory.getOutputView().printErrorMessage(ExceptionMessage.MOVE.getMessage());
            }
        }
    }
}
