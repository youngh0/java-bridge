package bridge;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.repository.BridgeLength;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private GameResult gameResult;
    private int tryCount = 1;

    public BridgeGame() {
        this.gameResult = new GameResult();
    }

    public boolean move(String playerMoving, Bridge bridge) {
        boolean move = bridge.isCanMove(playerMoving, gameResult.getCurrentStep());
        gameResult.updateResult(playerMoving, move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.gameResult = new GameResult();
        tryCount++;
    }

    public Bridge makeBridge(BridgeLength bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength.getBridgeLength());
        return new Bridge(bridge);
    }

    public int getTryCount() {
        return tryCount;
    }
}
