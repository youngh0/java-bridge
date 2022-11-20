package bridge.utils;

public enum BridgeSizeRange {
    MIN_BRIDGE_SIZE(3),
    MAX_BRIDGE_SIZE(20);

    private final int bridgeSize;

    BridgeSizeRange(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
