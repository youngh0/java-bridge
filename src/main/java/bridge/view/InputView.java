package bridge.view;

import bridge.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        try {
            InputValidator.validateBridgeSizeInput(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println("error");
            readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String playerMoving = Console.readLine();
        try {
            InputValidator.validatePlayerMovingInput(playerMoving);
        } catch (IllegalArgumentException exception) {
            readMoving();
        }
        return playerMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }


}
