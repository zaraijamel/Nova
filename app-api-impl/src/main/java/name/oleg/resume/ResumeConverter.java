package name.oleg.resume;

import fr.opensagres.xdocreport.converter.*;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import name.oleg.resume.data.ResumeFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ResumeConverter {

    public void convert(ResumeFormat resumeFormat, File sourceFile, File destinationFile) throws XDocConverterException, FileNotFoundException {
        Options options = Options.getFrom(DocumentKind.DOCX).to(ConverterTypeTo.PDF);
        IConverter converter = ConverterRegistry.getRegistry().getConverter(options);
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
        converter.convert(fileInputStream, fileOutputStream, options);
    }
}
