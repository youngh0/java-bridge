package bridge.utils.input;

import bridge.constant.ExceptionMessage;
import bridge.factory.ViewFactory;

public class RetryInput {
    private RetryInput() {

    }

    public static String inputRetry() {
        while (true) {
            try {
                return ViewFactory.getInputView().readGameCommand();
            } catch (IllegalArgumentException exception) {
                ViewFactory.getOutputView().printErrorMessage(ExceptionMessage.RETRY_INPUT.getMessage());
            }
        }
    }
}
