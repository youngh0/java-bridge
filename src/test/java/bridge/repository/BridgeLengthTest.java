package bridge.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeLengthTest {
    @ParameterizedTest
    @ValueSource(strings = {"2", "q", "21", ""})
    void 다리길이_유효성_검사(String bridgeLengthInput) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BridgeLength(bridgeLengthInput));
    }
}