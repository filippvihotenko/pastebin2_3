/* package by.viho.pastebin2_3.businessLogicModule.mappingObjectsService;

import by.viho.pastebin2_3.businessLogicModule.service.PostService;
import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.mapper.ModelMapperConf;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsServiceMappingFacade
{
    private PostService postService;

    public Iterable<PostDTO> findALlPosts(){
        return postService.getPostsFromRepo().stream().map(post -> ModelMapperConf.convertTo(post, PostDTO.class)).collect(Collectors.toList());
    }

    public void createPost(PostDTO postDTO){
        postService.createPost(ModelMapperConf.convertTo(postDTO, Post.class));
    }

} */
