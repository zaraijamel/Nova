package name.oleg.controller.util;

public class Pagination {
    private static final int MIN_DISPLAYED_PAGES = 5;
    private static final int MAX_DISPLAYED_PAGES = 10;
    private int currentPage;
    private int beginPage;
    private int endPage;
    private int totalPages;

    public Pagination(int currentPage, int totalPages) {
        this.totalPages = totalPages;
        this.currentPage = currentPage + 1;
        beginPage = Math.max(1, currentPage - MIN_DISPLAYED_PAGES);
        endPage = Math.min(beginPage + MAX_DISPLAYED_PAGES, totalPages);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
