 package by.viho.pastebin2_3.businessLogicModule.controller;

 import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
 import lombok.AllArgsConstructor;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
@AllArgsConstructor
public class MainPageController
{

    @GetMapping
    public String returnsMainPage(Model model){
        model.addAttribute("post", new PostDTO());
        return "index";
    }


}
