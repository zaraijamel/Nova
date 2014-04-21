package name.oleg.controller;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.google.code.linkedinapi.schema.Person;
import name.oleg.controller.util.LinkedinPersonaProcessor;
import name.oleg.resume.ResumeServiceImpl;
import name.oleg.resume.data.ResumeData;
import name.oleg.resume.data.ResumeTemplate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/resume/save", method = RequestMethod.POST)
    public String sendResumeToUser(@ModelAttribute("resumeData") ResumeData resumeData, HttpServletResponse response) {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=resume.pdf");
        try {
            resumeService.generateResume(response.getOutputStream(), resumeData, null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "resumeError";
        }
        return "resumeSuccessful";
    }

    @RequestMapping(value = "/resume/generate", method = RequestMethod.POST)
    public String generate(HttpServletResponse response, HttpServletRequest request) {
        ResumeData resumeData = (ResumeData) request.getAttribute("resumeData");
        if (resumeData == null) {
            return "resumeError";
        }

        try {
//            resumeGenerator.generate(resumeData, new File(""), new File(""));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "resumeError";
        }
        return "resumeSuccessful";
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
        model.addAttribute("number", fieldId);
        return "formRecommendationInsert";
    }

    @RequestMapping("/resumeTemplate")
    public String resumeTemplate(@ModelAttribute("resumeData") ResumeData resumeData, HttpServletResponse response, HttpServletRequest request, Model model) {
        request.setAttribute("resumeData", resumeData);
        model.addAttribute("resumeTemplates", ResumeTemplate.values());
        return "resumeTemplate";
    }
}
