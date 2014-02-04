package name.oleg.service;

import org.scriptlet4docx.docx.DocxTemplater;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Service
public class ResumeGeneratorImpl implements ResumeGenerator {

    @Override
    public void generate(ResumeData resumeData, File inputFile, File outputFile) {
        DocxTemplater docxTemplater = new DocxTemplater(inputFile);
        docxTemplater.process(outputFile, getParameters(resumeData));
    }

    private Map<String, Object> getParameters(ResumeData resumeData) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(resumeData.getClass());
        for (Method method : methods) {
            Object value = ReflectionUtils.invokeMethod(method, resumeData);
            parameters.put(method.getName(), value);
        }
        return parameters;
    }
}
