package by.viho.pastebin2_3.businessLogicModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginPageCotroller
{
    @GetMapping
    public String getLogin(){
        return "login";
    }
}
