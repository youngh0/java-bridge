package bridge;

import bridge.domain.Bridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class BridgeGameTest {
    Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));

    @ParameterizedTest
    @CsvSource(value = {"U,true", "D,false"})
    void 사용자_입력으로_정답_여부_테스트(String playerMoving, boolean answer) {
        BridgeGame bridgeGame = new BridgeGame();
        Assertions.assertThat(bridgeGame.move(playerMoving, bridge)).isEqualTo(answer);
    }
}