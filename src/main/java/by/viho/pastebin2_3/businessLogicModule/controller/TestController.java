package by.viho.pastebin2_3.businessLogicModule.controller;

import by.viho.pastebin2_3.businessLogicModule.mappingObjectsService.AnauthorizedPostServiceFacade;
import by.viho.pastebin2_3.businessLogicModule.mappingObjectsService.PostsServiceMappingFacade;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.bootstrap.RoleSeeder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/testposts"))
@AllArgsConstructor
public class TestController
{
    private final RoleSeeder roleSeeder;
    private AnauthorizedPostServiceFacade anauthorizedPostServiceFacade;

    @PostMapping
    public HttpStatus createPost(@RequestBody PostDTO postDTO) {
            anauthorizedPostServiceFacade.createPost(postDTO);
            return HttpStatus.CREATED;
    }
}
