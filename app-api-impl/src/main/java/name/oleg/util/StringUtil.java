package name.oleg.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringUtil {

    public static List<String> splitByWords(String text) {
        if (text == null) {
            return Collections.emptyList();
        }

        String[] split = text.split("\\w{4,}");
        return Arrays.asList(split);
    }
}
