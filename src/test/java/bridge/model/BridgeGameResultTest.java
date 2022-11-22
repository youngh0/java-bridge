package bridge.model;

import bridge.utils.BridgeGameResultStatus;
import bridge.utils.BridgeStep;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("게임 진행 결과 테스트")
class BridgeGameResultTest {
    private final BridgeGameResult bridgeGameResult = new BridgeGameResult(4);

    @BeforeEach
    void setUp() {
        bridgeGameResult.addResult(0, BridgeGameResultStatus.CORRECT, BridgeStep.UP.getStep());
        bridgeGameResult.addResult(1, BridgeGameResultStatus.CORRECT, BridgeStep.DOWN.getStep());
        bridgeGameResult.addResult(2, BridgeGameResultStatus.CORRECT, BridgeStep.DOWN.getStep());
    }

    @Test
    @DisplayName("게임 재시작 시 각 다리의 결과를 공백으로 초기화")
    void resetResultTest() {
        bridgeGameResult.resetResult();
        String answer = "[   |   ]\n[   |   ]";

        Assertions.assertThat(bridgeGameResult.getCurrentResult(2).toString()).isEqualTo(answer);
    }

    @Nested
    @DisplayName("다리의 마지막 칸 까지 건넜는지 테스트")
    class GameClearTest {
        @Test
        @DisplayName("다리의 마지막까지 건넌 경우")
        void isGameSuccessTest() {
            BridgeGameResult bridgeGameResult = new BridgeGameResult(4);
            bridgeGameResult.addResult(3, BridgeGameResultStatus.CORRECT, BridgeStep.UP.getStep());

            Assertions.assertThat(bridgeGameResult.isGameSuccess()).isEqualTo(true);
        }

        @Test
        @DisplayName("아직 다리의 마지막 칸에 도달하지 못한 경우")
        void isGameSuccessEmptyFailTest() {
            BridgeGameResult bridgeGameResult = new BridgeGameResult(4);

            Assertions.assertThat(bridgeGameResult.isGameSuccess()).isEqualTo(false);
        }

        @Test
        @DisplayName("다리의 마지막 칸에서 잘못 고른 경우")
        void isGameSuccessWrongFailTest() {
            BridgeGameResult bridgeGameResult = new BridgeGameResult(4);
            bridgeGameResult.addResult(3, BridgeGameResultStatus.FAIL, BridgeStep.UP.getStep());

            Assertions.assertThat(bridgeGameResult.isGameSuccess()).isEqualTo(false);
        }
    }
}