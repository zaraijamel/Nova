package name.oleg.util;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpUtil {

    public static String getPage(HttpResponse httpResponse) throws IOException {
        BufferedReader bufferedReader = null;
        InputStream content = null;
        StringBuilder builder = new StringBuilder();
        try {
            content = httpResponse.getEntity().getContent();
            bufferedReader = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } finally {
            if (content != null) {
                content.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }
}
