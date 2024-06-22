package by.viho.pastebin2_3.businessLogicModule.service;




import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostService
{
    List<Post> getPostsFromRepo();

    Optional<Post> findPostById(UUID id);

    Post createPost(Post post);

    void deletePost(UUID id);

    Page<Post> findByTitleContainingIgnoreCase(String keywords, Pageable pageable);
    Page<Post> findAll(Pageable pageable);

}
