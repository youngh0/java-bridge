package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class BridgeTest {
    Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));

    @ParameterizedTest
    @CsvSource(value = {"U:0:true", "U:1:false"}, delimiter = ':')
    void 현재_플레이어의_입력_정답_판단_테스트(String moving, int index, boolean answer) {
        Assertions.assertThat(bridge.isCanMove(moving, index)).isEqualTo(answer);
    }
}