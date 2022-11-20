package bridge.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"q","","2","21","03"})
    void validateBridgeSizeInputExceptionTest(String bridgeSize) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateBridgeSizeInput(bridgeSize));
    }
}