package bridge.model;

import bridge.constant.GameConstants;
import bridge.utils.BridgeGameResultStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BridgeStair {
    private final List<String> currentResult;
    private final int bridgeSize;

    public BridgeStair(int bridgeSize) {
        currentResult = new ArrayList<>();
        this.bridgeSize = bridgeSize;
    }

    public void addResult(BridgeGameResultStatus stepResult) {
        currentResult.add(stepResult.getResultStatus());
    }

    public boolean isGameSuccess() {
        return currentResult.size() == bridgeSize
                && currentResult.get(currentResult.size() - 1).equals(BridgeGameResultStatus.CORRECT.getResultStatus());
    }

    public StringJoiner getCurrentResult() {
        StringJoiner bridgeResultMessage = new StringJoiner(GameConstants.resultDelimiter, GameConstants.resultPrefix, GameConstants.resultPostfix);
        for (String result : currentResult) {
            bridgeResultMessage.add(result);
        }
        return bridgeResultMessage;
    }
}
