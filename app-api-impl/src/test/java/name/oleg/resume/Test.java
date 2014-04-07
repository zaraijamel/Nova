package name.oleg.resume;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import name.oleg.resume.data.*;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("D:\\template2.docx"));
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(fileInputStream, TemplateEngineKind.Velocity);

            IContext context = report.createContext();
            context.put("rd", getResumeData());

            OutputStream out = new FileOutputStream(new File("D:\\result.docx"));
            report.process(context, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }

        try {
            InputStream is = new FileInputStream(new File("D:\\result.docx"));
            XWPFDocument document = new XWPFDocument(is);

            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(
                    "D:\\rrrr.pdf"));
            PdfConverter.getInstance().convert(document, out, options);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static ResumeData getResumeData() {
        ResumeData resumeData = new ResumeData();
        resumeData.setFirstName("Oleg");
        resumeData.setMiddleName("Valeryevich");
        resumeData.setLastName("Birulia");
        resumeData.setGoal("Goals goals goals goals goals goals goals goals goals");
        resumeData.setWebsite("http://www.tut.by");
        resumeData.setEmail("inmate08@gmail.com");

        Address address = new Address();
        address.setCity("Minsk");
        resumeData.setAddress(address);

        List<Education> educations = new ArrayList<Education>();
        Education education = new Education();
        education.setSpecialty("Specialty");
        education.setAcademicDegree("Academic degree");
        education.setInstitution("Institution");
        education.setStartDate(Calendar.getInstance().getTime());
        education.setEndDate(Calendar.getInstance().getTime());
        educations.add(education);

        education = new Education();
        education.setSpecialty("Specialty");
        education.setAcademicDegree("Academic degree");
        education.setInstitution("Institution");
        education.setStartDate(Calendar.getInstance().getTime());
        education.setEndDate(Calendar.getInstance().getTime());
        educations.add(education);
        resumeData.setEducations(educations);

        List<Experience> experiences = new ArrayList<Experience>();
        Experience experience = new Experience();
        experience.setOrganization("Belprime");
        experience.setPosition("Programmer");
        experience.setResponsibility("Java-Developer");
        experience.setStartDate(Calendar.getInstance().getTime());
        experience.setEndDate(Calendar.getInstance().getTime());
        experiences.add(experience);

        experience = new Experience();
        experience.setOrganization("Belprime");
        experience.setPosition("Programmer");
        experience.setResponsibility("Java-Developer");
        experience.setStartDate(Calendar.getInstance().getTime());
        experience.setEndDate(Calendar.getInstance().getTime());
        experiences.add(experience);
        resumeData.setExperiences(experiences);

        List<Ability> abilities = new ArrayList<Ability>();
        Ability ability = new Ability();
        ability.setTitle("Ability title");
        ability.setDescription("Ability description description description description description description description description description" +
                "description description description description description description description description");
        abilities.add(ability);

        ability = new Ability();
        ability.setTitle("Ability title");
        ability.setDescription("Ability description description description description description description description description description" +
                "description description description description description description description description");
        abilities.add(ability);
        resumeData.setAbilities(abilities);

        return resumeData;
    }
}
