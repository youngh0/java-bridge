package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> bridgeInfo;

    public Bridge(List<String> bridgeInfo) {
        this.bridgeInfo = Collections.unmodifiableList(bridgeInfo);
    }
}
