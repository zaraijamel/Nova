package name.oleg.controller;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.google.code.linkedinapi.schema.Person;
import name.oleg.controller.util.LinkedinPersonaProcessor;
import name.oleg.data.form.ResumeSettingsForm;
import name.oleg.resume.ResumeServiceImpl;
import name.oleg.resume.data.ResumeData;
import name.oleg.resume.data.ResumeFormat;
import name.oleg.resume.data.ResumeTemplate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ResumeController {
    private static Logger logger = Logger.getLogger(ResumeController.class);

    @Autowired
    private LinkedInOAuthService oAuthServiceFactory;

    @Autowired
    private LinkedInApiClientFactory clientFactory;

    @Autowired
    private ResumeServiceImpl resumeService;

    @ModelAttribute("resumeData")
    public ResumeData getClassCommand() {
        return new ResumeData();
    }

    @RequestMapping("/resume")
    public String request(Model model) {
        model.addAttribute("resumeData", new ResumeData());
        return "resume";
    }

    @RequestMapping(value = "/resume/generate", method = RequestMethod.POST)
    public String generate(@ModelAttribute("resumeSettings") ResumeSettingsForm resumeSettingsForm, HttpServletRequest request, HttpServletResponse response) {
        ResumeData resumeData = (ResumeData) request.getSession().getAttribute("resumeData");
        if (resumeData == null) {
            return "resumeError";
        }

        try {
            ResumeFormat resumeFormat = resumeSettingsForm.getResumeFormat();
            if (resumeFormat == ResumeFormat.PDF) {
                response.setContentType("application/pdf");
                response.setHeader("Content-disposition", "inline; filename=resume.pdf");
                resumeService.generatePDFResume(response.getOutputStream(), resumeData, resumeSettingsForm.getResumeTemplate());
            } else if (resumeFormat == ResumeFormat.WORD) {
                response.setContentType("application/msword");
                response.setHeader("Content-disposition", "inline; filename=resume.docx");
                resumeService.generateWordResume(response.getOutputStream(), resumeData, resumeSettingsForm.getResumeTemplate());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "resumeError";
        }
        return null;
    }

    @RequestMapping("/resume/requestLinkedin")
    public String requestLinkedinAccessToken(HttpSession session) {
        LinkedInRequestToken requestToken = oAuthServiceFactory.getOAuthRequestToken("http://localhost:8080/resume/responseLinkedin");
        String authorizationUrl = requestToken.getAuthorizationUrl();
        session.setAttribute("requestToken", requestToken);
        return "redirect:" + authorizationUrl;
    }

    @RequestMapping("/resume/responseLinkedin")
    public String responseLinkedinAccessToken(HttpServletRequest request, Model model) {
        LinkedInRequestToken requestToken = (LinkedInRequestToken) request.getSession().getAttribute("requestToken");
        if (requestToken == null) {
            logger.error("Request token null");
            return "resumeError";
        }

        String oauthVerifier = request.getParameter("oauth_verifier");
        if (oauthVerifier == null) {
            logger.error("OauthVerifier null");
            return "resumeError";
        }

        LinkedInAccessToken accessToken = oAuthServiceFactory.getOAuthAccessToken(requestToken, oauthVerifier);
        LinkedInApiClient linkedInApiClient = clientFactory.createLinkedInApiClient(accessToken);
        Person profileForCurrentUser = linkedInApiClient.getProfileForCurrentUser();
        LinkedinPersonaProcessor linkedinPersonaProcessor = new LinkedinPersonaProcessor();
        ResumeData resumeData = linkedinPersonaProcessor.toResumeData(profileForCurrentUser);
        model.addAttribute("resumeData", resumeData);
        return "resume";
    }

    @RequestMapping("/appendRecommendation")
    public String appendRecommendation(@RequestParam Integer fieldId, Model model) {
        model.addAttribute("recommendationIndex", fieldId);
        return "formRecommendationInsert";
    }

    @RequestMapping("/appendAbility")
    public String appendAbility(@RequestParam Integer fieldId, Model model) {
        model.addAttribute("abilityIndex", fieldId);
        return "formAbilityAppend";
    }

    @RequestMapping("/appendExperience")
    public String appendExperience(@RequestParam Integer fieldId, Model model) {
        model.addAttribute("experienceIndex", fieldId);
        return "formExperienceAppend";
    }

    @RequestMapping("/appendEducation")
    public String appendEducation(@RequestParam Integer fieldId, Model model) {
        model.addAttribute("educationIndex", fieldId);
        return "formEducationAppend";
    }

    @RequestMapping(value = "/resumeSettings", method = RequestMethod.POST)
    public String resumeTemplate(@ModelAttribute("resumeData")/* @Valid*/ ResumeData resumeData, BindingResult result, HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            return "resume";
        }

        request.getSession().setAttribute("resumeData", resumeData);
        model.addAttribute("resumeSettings", new ResumeSettingsForm());
        model.addAttribute("resumeTemplates", ResumeTemplate.values());
        model.addAttribute("resumeFormats", ResumeFormat.values());
        return "resumeSettings";
    }
}
