package name.oleg.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Util {

    public static Long getLongOrNull(String value) {
        return value == null ? null : Long.parseLong(value);
    }

    public static Integer getIntegerOrNull(String value) {
        return value == null ? null : Integer.parseInt(value);
    }

    public static Date getDateOrNull(String value, DateFormat dateFormat) throws ParseException {
        return value == null ? null : dateFormat.parse(value);
    }
}
