package bridge;

import bridge.model.Bridge;
import bridge.utils.BridgeNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

@DisplayName("각 스템 별로 사용자 입력이 해당 다리 칸을 건널 수 있는지")
class BridgeTest {
    @ParameterizedTest
    @CsvSource(value = {"0:U", "1:D", "2:D", "3:U"}, delimiter = ':')
    @DisplayName("입력과 다리의 해당 칸 값이 일치한다면 true")
    void isPassStepTest(int index, String moving) {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(4));
        assertThat(bridge.isPassStep(index, moving)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:D", "1:U", "2:U", "3:D"}, delimiter = ':')
    @DisplayName("입력과 다리의 해당 칸 값이 일치하지 않으면 false")
    void isPassStepFalseTest(int index, String moving) {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(4));
        assertThat(bridge.isPassStep(index, moving)).isEqualTo(false);
    }
}