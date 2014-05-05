package name.oleg.resume.data;

public enum ResumeTemplate {
    TEMPLATE1("Первый шаблон", "Описание", "template1", "template1"),
    TEMPLATE2("Первый шаблон", "Описание", "template2", "template2"),
    TEMPLATE3("Первый шаблон", "Описание", "template3", "template3"),
    TEMPLATE4("Первый шаблон", "Описание", "template4", "template4"),
    TEMPLATE5("Первый шаблон", "Описание", "template5", "template5");

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
