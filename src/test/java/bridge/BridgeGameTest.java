package bridge;

import bridge.domain.Bridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class BridgeGameTest {
    Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));
    BridgeGame bridgeGame = new BridgeGame();

    @ParameterizedTest
    @CsvSource(value = {"U,true", "D,false"})
    void 사용자_입력으로_정답_여부_테스트(String playerMoving, boolean answer) {

        Assertions.assertThat(bridgeGame.move(playerMoving, bridge)).isEqualTo(answer);
    }

    @Test
    void 재시작시_게임시도횟수_변경_테스트() {
        bridgeGame.retry();
        Assertions.assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }


}