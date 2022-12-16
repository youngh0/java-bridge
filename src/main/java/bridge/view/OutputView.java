package bridge.view;

import bridge.dto.ResultDto;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String error = "[ERROR] %s";

    public void printGameStartLine() {
        System.out.println(PrintConstant.GAME_START.getPrintLine());
    }

    public void printErrorMessage(String message) {
        System.out.println(String.format(error, message));
    }

    public void printMap(ResultDto result) {
        System.out.println(result.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
