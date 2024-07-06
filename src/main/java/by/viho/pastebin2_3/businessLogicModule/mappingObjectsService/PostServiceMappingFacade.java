/* package by.viho.pastebin2_3.businessLogicModule.mappingObjectsService;

import by.viho.pastebin2_3.businessLogicModule.service.PostService;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.mapper.ModelMapperConf;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PostServiceMappingFacade
{

    private PostService postService;

    public PostDTO getPostById(UUID uuid)
    {
        return  ModelMapperConf.convertTo(postService.findPostById(uuid), PostDTO.class);
    }

    public void deletePost(UUID uuid){
        postService.deletePost(uuid);
    }
}  */

