package bridge.repository;

public class BridgeLength {
    private final int bridgeLength;

    public BridgeLength(String bridgeLength) {
        validate(bridgeLength);
        this.bridgeLength = Integer.parseInt(bridgeLength);
    }

    private void validate(String bridgeLength) {
        validateIsNumber(bridgeLength);
        validateLengthRange(Integer.parseInt(bridgeLength));
    }

    private void validateIsNumber(String bridgeLength) {
        try {
            Integer.parseInt(bridgeLength);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 다리 길이 입력입니다.");
        }
    }

    private void validateLengthRange(int bridgeLength) {
        if (bridgeLength < 3 || bridgeLength > 20) {
            throw new IllegalArgumentException("다리 길이 범위를 벗어났습니다.");
        }
    }
}
