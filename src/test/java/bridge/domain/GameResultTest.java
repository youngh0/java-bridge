package bridge.domain;

import bridge.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameResultTest {
    BridgeGame bridgeGame = new BridgeGame();
    GameResult gameResult = new GameResult();
    Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));

    @Test
    void updateResult() {
        GameResult gameResult = new GameResult();
        gameResult.updateResult("U", true);
        Assertions.assertThat(gameResult.getCurrentStep()).isEqualTo(1);
    }

    @Test
    void 재시작시_게임결과_초기화_테스트() {
        bridgeGame.move("U", bridge);
        bridgeGame.retry();
        Assertions.assertThat(gameResult.getCurrentStep()).isEqualTo(0);
    }
}