package bridge.view;

import bridge.constant.GameConstants;

public class OutputView {
    public void printBridgeGameStart() {
        System.out.println(GameConstants.startGameMessage);
    }

    public void printMap(StringBuffer currentResult) {
        System.out.println(currentResult);
    }

    public void printResult(StringBuffer finalResult) {
        System.out.println(finalResult);
    }
}
