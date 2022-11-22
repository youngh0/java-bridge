package bridge;

import bridge.controller.GamePlayController;
import bridge.controller.GameSettingController;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeGameResult;

public class Application {
    public static void main(String[] args) {
        GameSettingController gameSettingController = new GameSettingController();
        Bridge bridge = gameSettingController.generateBridge(new BridgeRandomNumberGenerator());

        GamePlayController gamePlayController = new GamePlayController(new BridgeGame(bridge), new BridgeGameResult(bridge.getBridgeSize()));
        gamePlayController.startGame();
    }
}
