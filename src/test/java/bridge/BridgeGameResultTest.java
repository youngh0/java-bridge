package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeGameResult;
import bridge.utils.BridgeNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameResultTest {

    @Test
    void getCurrentResultTest() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(4));
        BridgeGameResult bridgeGameResult = new BridgeGameResult(bridge.getBridgeSize());

        new BridgeGame(bridge).move(0, "U", bridgeGameResult);
        StringBuffer currentResult = bridgeGameResult.getCurrentResult(1);
        System.out.println(currentResult);
        String answer = "[ O ]\n[   ]";

        Assertions.assertThat(currentResult.toString()).isEqualTo(answer);
    }
}