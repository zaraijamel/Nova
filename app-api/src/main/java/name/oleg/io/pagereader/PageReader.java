package name.oleg.io.pagereader;

import java.io.IOException;

public interface PageReader {

    public PageContent readPage(String url) throws IOException;
}
