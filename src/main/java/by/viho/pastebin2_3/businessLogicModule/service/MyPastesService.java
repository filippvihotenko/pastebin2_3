package by.viho.pastebin2_3.businessLogicModule.service;

import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MyPastesService {



    Page<PostDTO> findPostsBySenderIdIgnoreCase(Pageable pageable);


    Page<PostDTO> findPostsBySenderIdIgnoreCaseWithKeyword( Pageable pageable, String keyword);
    public void dislikePost(UUID item_id);

    void likePost(UUID postId);
}
