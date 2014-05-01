package name.oleg.io.pagereader;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;

@Component
public class HttpClientPageReader implements PageReader {

    @Override
    public PageContent readPage(String url) throws IOException {
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            response = httpClient.execute(new HttpGet(url));
            HttpEntity entity = response.getEntity();
            Header contentEncodingHeader = entity.getContentEncoding();
            StringWriter writer = new StringWriter();
            IOUtils.copy(entity.getContent(), writer, contentEncodingHeader != null ? contentEncodingHeader.getValue() : "UTF-8");
            StatusLine statusLine = response.getStatusLine();
            return new PageContent(writer.toString(), statusLine.getStatusCode());
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
}
