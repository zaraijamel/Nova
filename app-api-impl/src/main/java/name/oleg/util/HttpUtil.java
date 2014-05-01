package name.oleg.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class HttpUtil {

    public static String buildQueryParameters(Map<String, String> parameters) throws UnsupportedEncodingException {
        final StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            builder.append(entry.getKey());
            builder.append('=');
            builder.append(URLEncoder.encode(entry.getValue(), "utf-8"));
            if (iterator.hasNext()) {
                builder.append("&");
            }
        }
        return builder.toString();
    }
}
