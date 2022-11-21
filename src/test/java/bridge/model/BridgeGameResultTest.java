package bridge.model;

import bridge.utils.BridgeGameResultStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameResultTest {
    private final BridgeGameResult bridgeGameResult = new BridgeGameResult(4);

    @BeforeEach
    void setUp() {
        bridgeGameResult.addResult(0, BridgeGameResultStatus.CORRECT, "U");
        bridgeGameResult.addResult(1, BridgeGameResultStatus.CORRECT, "D");
        bridgeGameResult.addResult(2, BridgeGameResultStatus.CORRECT, "D");
    }

    @Test
    void resetResultTest() {
        bridgeGameResult.resetResult();
        String answer = "[   |   ]\n[   |   ]\n";

        Assertions.assertThat(bridgeGameResult.getCurrentResult(2).toString()).isEqualTo(answer);
    }

    @Test
    void isGameSuccessTest() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult(4);
        bridgeGameResult.addResult(3, BridgeGameResultStatus.CORRECT, "U");

        Assertions.assertThat(bridgeGameResult.isGameSuccess()).isEqualTo(true);
    }

    @Test
    void isGameSuccessEmptyFailTest() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult(4);

        Assertions.assertThat(bridgeGameResult.isGameSuccess()).isEqualTo(false);
    }

    @Test
    void isGameSuccessWrongFailTest() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult(4);
        bridgeGameResult.addResult(3, BridgeGameResultStatus.FAIL, "U");

        Assertions.assertThat(bridgeGameResult.isGameSuccess()).isEqualTo(false);
    }

}