package bridge.model;

import bridge.utils.BridgeGameResultStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGameResult {
    private final List<String> upResult;
    private final List<String> downResult;
    private int gameTryCount = 0;

    public BridgeGameResult(int bridgeSize) {
        String[] initResult = new String[bridgeSize];
        Arrays.fill(initResult, BridgeGameResultStatus.EMPTY.getResultStatus());
        upResult = new ArrayList<>(Arrays.asList(initResult));
        downResult = new ArrayList<>(Arrays.asList(initResult));
    }

    public void addResult(int index, BridgeGameResultStatus stepResult, String direction) {
        if (direction.equals("U")) {
            upResult.set(index, stepResult.getResultStatus());
            return;
        }
        downResult.set(index, stepResult.getResultStatus());
    }

    public void resetResult() {
        gameTryCount++;
        for (int index = 0; index < upResult.size(); index++) {
            upResult.set(index, BridgeGameResultStatus.EMPTY.getResultStatus());
            downResult.set(index, BridgeGameResultStatus.EMPTY.getResultStatus());
        }
    }

    public boolean isGameSuccess() {
        return upResult.get(upResult.size() - 1).equals(BridgeGameResultStatus.CORRECT.getResultStatus())
                || downResult.get(downResult.size() - 1).equals(BridgeGameResultStatus.CORRECT.getResultStatus());
    }

    public StringBuffer getCurrentResult(int index) {
        StringBuffer currentResult = new StringBuffer();
        currentResult.append("[ ");
        currentResult.append(String.join(" | ", upResult.subList(0, index)));
        currentResult.append(" ]\n");
        currentResult.append("[ ");
        currentResult.append(String.join(" | ", downResult.subList(0, index)));
        currentResult.append(" ]\n");
        return currentResult;
    }

    public StringBuffer getFinalResult(int index, boolean isGameSuccess) {
        StringBuffer result = new StringBuffer();
        result.append("최종 게임 결과\n");
        result.append(getCurrentResult(index));
        result.append("\n").append("게임 성공 여부: ");
        if (isGameSuccess) {
            result.append("성공\n");
        }
        result.append("실패\n");
        result.append("총 시도한 횟수: ").append(gameTryCount);
        return result;
    }
}