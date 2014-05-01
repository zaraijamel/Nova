package name.oleg.resume.data;

public enum ResumeTemplate {
    SIMPLE("Первый шаблон", "Описание", "simple", "template1"),
    SIMPLE1("Первый шаблон", "Описание", "simple", "template1"),
    SIMPLE2("Первый шаблон", "Описание", "simple", "template1");

    private String name;
    private String description;
    private String imageName;
    private String fileName;

    private ResumeTemplate(String name, String description, String imageName, String fileName) {
        this.name = name;
        this.description = description;
        this.imageName = imageName;
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public String getImageName() {
        return imageName;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }
}
