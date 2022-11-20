package bridge.utils;

public enum BridgeStep {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String step;

    BridgeStep(int number, String step) {
        this.number = number;
        this.step = step;
    }

    public int getNumber() {
        return number;
    }

    public String getStep() {
        return step;
    }
}
