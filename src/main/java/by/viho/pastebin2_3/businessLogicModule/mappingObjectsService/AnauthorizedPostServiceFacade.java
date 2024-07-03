package by.viho.pastebin2_3.businessLogicModule.mappingObjectsService;

import by.viho.pastebin2_3.businessLogicModule.service.AnauthorizedPostService;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import by.viho.pastebin2_3.pasteSendingModule.mapper.ModelMapperConf;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnauthorizedPostServiceFacade {

    private AnauthorizedPostService anauthorizedPostService;

    public void createPost(PostDTO postDTO){
        anauthorizedPostService.createPost(ModelMapperConf.convertTo(postDTO, Post.class));
    }

}
