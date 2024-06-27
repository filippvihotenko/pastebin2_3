
package by.viho.pastebin2_3.businessLogicModule.controller;

import by.viho.pastebin2_3.businessLogicModule.mappingObjectsService.PostsServiceMappingFacade;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.bootstrap.RoleSeeder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(("/posts"))
@AllArgsConstructor
public class PostsController
{
    private final RoleSeeder roleSeeder;
    private PostsServiceMappingFacade postsServiceMappingFacade;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public String createPost(@Valid  PostDTO postDTO, BindingResult bindingResult, Model model) throws BindException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).toList());
            model.addAttribute("post", postDTO);
            return "index";
        } else {
            postsServiceMappingFacade.createPost(postDTO);
            return "redirect:/index";
        }
    }
}

