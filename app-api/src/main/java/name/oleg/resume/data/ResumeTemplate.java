package name.oleg.resume.data;

public enum ResumeTemplate {
    SIMPLE("test");

    private String name;

    ResumeTemplate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
