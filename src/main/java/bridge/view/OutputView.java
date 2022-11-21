package bridge.view;

public class OutputView {
    public void printBridgeGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printMap(StringBuffer currentResult) {
        System.out.println(currentResult);
    }

    public void printResult(StringBuffer finalResult) {
        System.out.println(finalResult);
    }
}
