
package by.viho.pastebin2_3.businessLogicModule.controller;

import by.viho.pastebin2_3.businessLogicModule.mappingObjectsService.PostsServiceMappingFacade;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(("/posts"))
@AllArgsConstructor
public class PostsController
{
    private PostsServiceMappingFacade postsServiceMappingFacade;

    @PreAuthorize("hasAuthority('ROLE_VERIFIED_USER')")
    @PostMapping
    public String createPost(@ModelAttribute("post") PostDTO postDTO){
        postsServiceMappingFacade.createPost(postDTO);
        return "redirect:/index";
    }
}

