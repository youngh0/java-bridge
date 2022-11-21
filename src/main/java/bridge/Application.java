package bridge;

import bridge.controller.GameSettingController;

public class Application {

    public static void main(String[] args) {
        GameSettingController gameSettingController = new GameSettingController();
        Bridge bridge = gameSettingController.generateBridge(new InputView(), new BridgeRandomNumberGenerator());
    }
}
