package bridge.domain;

import bridge.dto.ResultDto;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<String> upStairResult;
    private final List<String> downStairResult;

    public GameResult() {
        this.upStairResult = new ArrayList<>();
        this.downStairResult = new ArrayList<>();
    }

    public int getCurrentStep() {
        return upStairResult.size();
    }

    public void updateResult(String playerMoving, boolean answer) {
        addEmptyElement();
        if (playerMoving.equals("U")) {
            updateUpStair(answer);
            return;
        }
        updateDownStair(answer);
    }

    public ResultDto getResultDto() {
        return new ResultDto(upStairResult, downStairResult);
    }

    public boolean isLastStepAnswer() {
        return upStairResult.get(upStairResult.size() - 1).equals("O") || downStairResult.get(downStairResult.size() - 1).equals("O");
    }

    private void addEmptyElement() {
        upStairResult.add(" ");
        downStairResult.add(" ");
    }

    private void updateUpStair(boolean answer) {
        if (answer) {
            upStairResult.set(upStairResult.size() - 1, "O");
            return;
        }
        upStairResult.set(upStairResult.size() - 1, "X");
    }

    private void updateDownStair(boolean answer) {
        if (answer) {
            downStairResult.set(downStairResult.size() - 1, "O");
            return;
        }
        downStairResult.set(downStairResult.size() - 1, "X");
    }
}
