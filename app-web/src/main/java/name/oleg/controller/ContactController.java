package name.oleg.controller;

import name.oleg.data.form.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @RequestMapping(value = "/contact/add-message", method = RequestMethod.POST)
    public String addMessage(@ModelAttribute("contactForm") ContactForm contactForm) {

        return "contact";
    }
}