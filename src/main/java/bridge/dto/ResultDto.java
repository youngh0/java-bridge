package bridge.dto;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class ResultDto {
    private final List<String> upStair;
    private final List<String> downStair;

    public ResultDto(List<String> upStair, List<String> downStair) {
        this.upStair = Collections.unmodifiableList(upStair);
        this.downStair = Collections.unmodifiableList(downStair);
    }

    public String toString() {
        StringJoiner up = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner down = new StringJoiner(" | ", "[ ", " ]");
        for (int index = 0; index < upStair.size(); index++) {
            up.add(upStair.get(index));
            down.add(downStair.get(index));
        }

        return up + "\n" + down;
    }
}
