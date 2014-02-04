package name.oleg.service;

import java.util.Map;

public class ResumeParameter {
    private Map<String, Object> parameters;

    public ResumeParameter(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }
}
