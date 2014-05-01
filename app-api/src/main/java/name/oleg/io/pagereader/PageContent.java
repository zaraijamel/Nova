package name.oleg.io.pagereader;

public class PageContent {
    private String page;
    private int responseCode;

    public PageContent(String page, int responseCode) {
        this.page = page;
        this.responseCode = responseCode;
    }

    public String getPage() {
        return page;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
