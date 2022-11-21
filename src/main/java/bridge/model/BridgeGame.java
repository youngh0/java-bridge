package bridge.model;

import bridge.utils.BridgeGameResultStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean move(int index, String playerMoving, BridgeGameResult bridgeGameResult) {
        if (bridge.isPassStep(index, playerMoving)) {
            bridgeGameResult.addResult(index, BridgeGameResultStatus.CORRECT, playerMoving);
            return true;
        }
        bridgeGameResult.addResult(index, BridgeGameResultStatus.FAIL, playerMoving);
        return false;
    }

    public boolean retry(String gameCommand) {
        return gameCommand.equals("R");
    }
}
