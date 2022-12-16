package bridge.repository;

import java.util.Arrays;

public enum BridgeElement {
    UP(1, "U"),
    DOWN(0, "D");

    private final int randomNumber;
    private final String inputCommand;

    BridgeElement(int randomNumber, String inputCommand) {
        this.randomNumber = randomNumber;
        this.inputCommand = inputCommand;
    }

    public static BridgeElement findByPlayerInput(String inputCommand) {
        return Arrays.stream(BridgeElement.values())
                .filter(bridgeElement -> bridgeElement.getInputCommand().equals(inputCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 이동 입력입니다."));
    }

    public String getInputCommand() {
        return inputCommand;
    }
}
