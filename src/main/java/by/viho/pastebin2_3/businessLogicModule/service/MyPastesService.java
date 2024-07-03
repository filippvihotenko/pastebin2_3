package by.viho.pastebin2_3.businessLogicModule.service;

import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface MyPastesService {



    Page<Post> findPostsBySenderIdIgnoreCase( Pageable pageable);


    Page<Post> findPostsBySenderIdIgnoreCaseWithKeyword( Pageable pageable, String keyword);

}
