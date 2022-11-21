package bridge.utils;

import bridge.InputView;

public class InputValidator {
    private static final InputView inputView = new InputView();

    private InputValidator() {
    }

    public static void validateBridgeSizeInput(String bridgeSizeInputValue) {
        try {
            validateBridgeSizeType(bridgeSizeInputValue);
            validateBridgeSizeRange(convertToIntBridgeSize(bridgeSizeInputValue));
        } catch (IllegalArgumentException exception) {
            System.out.println("error");
            inputView.readBridgeSize();
        }
    }

    public static void validatePlayerMovingInput(String moving) {
        isMovingInputUOrD(moving);
    }

    private static void validateBridgeSizeType(String bridgeSize) {
        String bridgeTypeRegex = "^[1-9][0-9]?$";
        if (!bridgeSize.matches(bridgeTypeRegex)) {
            throw new IllegalArgumentException();
        }
    }

    private static int convertToIntBridgeSize(String bridgeSize) {
        return Integer.parseInt(bridgeSize);
    }

    private static void validateBridgeSizeRange(int bridgeSize) {
        int minBridgeSize = BridgeSizeRange.MIN_BRIDGE_SIZE.getBridgeSize();
        int maxBridgeSize = BridgeSizeRange.MAX_BRIDGE_SIZE.getBridgeSize();
        if (bridgeSize < minBridgeSize || bridgeSize > maxBridgeSize) {
            throw new IllegalArgumentException();
        }
    }

    private static void isMovingInputUOrD(String moving) {
        String movingRegex = "[UD]";
        if (!moving.matches(movingRegex)) {
            throw new IllegalArgumentException();
        }
    }
}
