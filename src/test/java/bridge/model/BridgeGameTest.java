package bridge.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @ParameterizedTest
    @CsvSource(value = {"R:true", "Q:false"}, delimiter = ':')
    void retryTest(String command, boolean isRetry) {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U")));
        assertThat(bridgeGame.retry(command)).isEqualTo(isRetry);
    }
}