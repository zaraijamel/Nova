package name.oleg.parser;

public enum VacancyParserType {
    TUT_BY("tutby", "http://www.tut.by"),
    HEAD_HUNTERS("headhunters", "http://www.hh.by"),
    YANDEX_JOB("yandex", "http://www.yandex.ru"),
    JOBLAB("joblab", ""),
    RDW("rdw", "");

    private String title;
    private String link;

    VacancyParserType(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
