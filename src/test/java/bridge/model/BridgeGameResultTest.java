package bridge.model;

import bridge.utils.BridgeGameResultStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeGameResultTest {

    @Test
    void resetResultTest() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult(4);
        bridgeGameResult.addResult(0, BridgeGameResultStatus.CORRECT, "U");
        bridgeGameResult.addResult(1, BridgeGameResultStatus.CORRECT, "D");
        bridgeGameResult.resetResult();
        String answer = "[   |   ]\n[   |   ]\n";

        Assertions.assertThat(bridgeGameResult.getCurrentResult(2).toString()).isEqualTo(answer);
    }

}