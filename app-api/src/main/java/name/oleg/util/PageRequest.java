package name.oleg.util;

public class PageRequest {
    public static final PageRequest EMPTY = new PageRequest();
    private int limit = -1;
    private int offset = -1;

    public PageRequest() {
    }

    public PageRequest(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }
}
