package bridge.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"q", "", "2", "21", "03"})
    @DisplayName("다리 길이는 3~20사이의 숫자인지 검사")
    void validateBridgeSizeInputExceptionTest(String bridgeSize) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateBridgeSizeInput(bridgeSize));
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "U ", ""})
    @DisplayName("사용자 이동 입력은 U, D중 하나만 가능하다")
    void validateMovingInputExceptionTest(String moving) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validatePlayerMovingInput(moving));
    }
}