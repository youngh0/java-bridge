package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void updateResult() {
        GameResult gameResult = new GameResult();
        gameResult.updateResult("U", true);
        Assertions.assertThat(gameResult.getCurrentStep()).isEqualTo(1);
    }
}