package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGameResult {
    List<String> upResult;
    List<String> downResult;

    public BridgeGameResult(int bridgeSize) {
        String[] initResult = new String[bridgeSize];
        Arrays.fill(initResult, " ");
        upResult = new ArrayList<>(Arrays.asList(initResult));
        downResult = new ArrayList<>(Arrays.asList(initResult));
    }
}
