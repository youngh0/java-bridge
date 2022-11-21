package bridge.factory;

import bridge.view.InputView;
import bridge.view.OutputView;

public class ViewFactory {
    private static OutputView outputView;
    private static InputView inputView;

    private ViewFactory() {
    }

    public static OutputView getOutputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public static InputView getInputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }
}
