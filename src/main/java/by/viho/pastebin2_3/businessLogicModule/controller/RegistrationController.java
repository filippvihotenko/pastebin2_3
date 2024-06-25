package by.viho.pastebin2_3.businessLogicModule.controller;

import by.viho.pastebin2_3.businessLogicModule.service.UserRegistrationService;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PersonDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    private UserRegistrationService userRegistrationService;

    @GetMapping
    public String register(Model model) {
        model.addAttribute("person", new PersonDTO());
        return "registration";
    }


    @PostMapping
    public String register(@ModelAttribute("person") PersonDTO personDTO) {
        userRegistrationService.signUpUser(personDTO);
        return "redirect:/index";
    }

}
