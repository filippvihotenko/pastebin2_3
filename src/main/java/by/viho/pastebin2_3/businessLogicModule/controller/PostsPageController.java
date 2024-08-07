
package by.viho.pastebin2_3.businessLogicModule.controller;

import by.viho.pastebin2_3.businessLogicModule.service.PostService;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostsPageController
{
    private PostService postService;

    public PostsPageController( PostService postService)
    {
        this.postService = postService;
    }

    @GetMapping
    public String getPosts(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(required = false) String keyword)
    {
        int size = 5;
        try{
            List<PostDTO> posts = new ArrayList<>();
            //using for parametrizing pagination
            Pageable paging = PageRequest.of(page - 1, size);
            Page<PostDTO> pageTuts;

            if (keyword == null) {
                pageTuts = postService.findAll(paging);
            } else {
                pageTuts = postService.findByTitleContainingIgnoreCase(keyword, paging);
                model.addAttribute("keyword", keyword);
            }
            posts = pageTuts.getContent();

            model.addAttribute("posts", posts);
            model.addAttribute("currentPage", pageTuts.getNumber() + 1);
            model.addAttribute("totalItems", pageTuts.getTotalElements());
            model.addAttribute("totalPages", pageTuts.getTotalPages());
            model.addAttribute("pageSize", size);

        }catch (Exception e){
            model.addAttribute("message", e.getMessage());
        }
        return "tutorials";
    }
}
