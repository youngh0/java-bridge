package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;


class BridgeTest {
    @ParameterizedTest
    @CsvSource(value = {"0:U", "1:D", "2:D", "3:U"}, delimiter = ':')
    void isPassStepTest(int index, String moving) {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(4));
        assertThat(bridge.isPassStep(index, moving)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:D", "1:U", "2:U", "3:D"}, delimiter = ':')
    void isPassStepFalseTest(int index, String moving) {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(4));
        assertThat(bridge.isPassStep(index, moving)).isEqualTo(false);
    }
}