package bridge.view;

public enum PrintConstant {
    GAME_START("다리 건너기 게임을 시작합니다.");

    private final String printLine;

    PrintConstant(String printLine) {
        this.printLine = printLine;
    }

    public String getPrintLine() {
        return printLine;
    }
}
