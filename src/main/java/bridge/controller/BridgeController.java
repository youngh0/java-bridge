package bridge.controller;

import bridge.BridgeGame;
import bridge.repository.BridgeLength;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        outputView.printGameStartLine();
        settingBridgeGame();
    }

    private void settingBridgeGame() {
        try {
            BridgeLength bridgeLength = inputView.readBridgeSize();
            bridgeGame.makeBridge(bridgeLength);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            settingBridgeGame();
        }
    }
}
