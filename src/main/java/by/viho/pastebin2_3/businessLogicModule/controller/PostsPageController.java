package by.viho.pastebin2_3.businessLogicModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostsPageController
{
    @GetMapping
    public String getPosts(Model model){
        return "posts";
    }
}
