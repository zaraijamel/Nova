package name.oleg.data.form;

import name.oleg.resume.data.ResumeFormat;
import name.oleg.resume.data.ResumeTemplate;

public class ResumeSettingsForm {
    private ResumeTemplate resumeTemplate = ResumeTemplate.SIMPLE;
    private ResumeFormat resumeFormat = ResumeFormat.PDF;

    public ResumeSettingsForm() {
    }

    public ResumeTemplate getResumeTemplate() {
        return resumeTemplate;
    }

    public void setResumeTemplate(ResumeTemplate resumeTemplate) {
        this.resumeTemplate = resumeTemplate;
    }

    public ResumeFormat getResumeFormat() {
        return resumeFormat;
    }

    public void setResumeFormat(ResumeFormat resumeFormat) {
        this.resumeFormat = resumeFormat;
    }
}
