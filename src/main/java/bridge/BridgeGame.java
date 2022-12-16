package bridge;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.dto.ResultDto;
import bridge.repository.BridgeLength;

import java.util.List;

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

    public ResultDto getResultDto() {
        return gameResult.getResultDto();
    }
}
