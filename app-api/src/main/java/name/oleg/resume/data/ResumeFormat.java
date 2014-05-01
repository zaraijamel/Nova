package name.oleg.resume.data;

public enum ResumeFormat {
    PDF("PDF (.pdf)"),
    WORD("Word (.docx)");

    private String name;

    private ResumeFormat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
