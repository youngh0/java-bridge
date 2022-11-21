package bridge.factory;

import bridge.view.OutputView;

public class ViewFactory {
    public OutputView createOutputView() {
        return new OutputView();
    }
}
