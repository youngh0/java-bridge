package bridge.model;

import bridge.utils.BridgeGameResultStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeGameResult {
    List<String> upResult;
    List<String> downResult;

    public BridgeGameResult(int bridgeSize) {
        String[] initResult = new String[bridgeSize];
        Arrays.fill(initResult, " ");
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
        this.upResult = resetResultValue(upResult);
        this.downResult = resetResultValue(downResult);
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

    private List<String> resetResultValue(List<String> result) {
        return result.stream()
                .map(x -> " ")
                .collect(Collectors.toList());
    }
}