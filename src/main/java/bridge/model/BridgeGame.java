package bridge.model;

import bridge.utils.BridgeGameResultStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final BridgeGameResult bridgeGameResult;

    public BridgeGame(Bridge bridge, BridgeGameResult bridgeGameResult) {
        this.bridge = bridge;
        this.bridgeGameResult = bridgeGameResult;
    }

    public void move(int index, String playerMoving) {
        if (bridge.isPassStep(index, playerMoving)) {
            bridgeGameResult.addResult(index, BridgeGameResultStatus.CORRECT, playerMoving);
            return;
        }
        bridgeGameResult.addResult(index, BridgeGameResultStatus.FAIL, playerMoving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
