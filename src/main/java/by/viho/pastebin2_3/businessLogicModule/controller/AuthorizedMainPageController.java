package by.viho.pastebin2_3.businessLogicModule.controller;

import by.viho.pastebin2_3.businessLogicModule.mappingObjectsService.PostsServiceMappingFacade;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
@AllArgsConstructor
public class AuthorizedMainPageController
{
    private PostsServiceMappingFacade postsServiceMappingFacade;

    @GetMapping
    public String returnsMainPage(Model model){
        model.addAttribute("post", new PostDTO());
        return "index";
    }

    @PostMapping()
    public String createPost(@ModelAttribute("post") PostDTO postDTO){
        postsServiceMappingFacade.createPost(postDTO);
        return "redirect:/index";
    }
}
