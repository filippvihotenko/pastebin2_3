package by.viho.pastebin2_3.businessLogicModule.service;

import by.viho.pastebin2_3.businessLogicModule.mappingObjectsService.AnauthorizedPostServiceFacade;
import by.viho.pastebin2_3.dataAccessModule.repository.PostRepo;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AnauthorizedPostService {

    private final PostRepo postRepo;

    public void createPost(Post post) {
        post.setPost_id(UUID.randomUUID());
        postRepo.save(post);
    }
}
