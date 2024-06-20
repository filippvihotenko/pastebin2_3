package by.viho.pastebin2_3.businessLogicModule.service;




import by.viho.pastebin2_3.pasteSendingModule.domain.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostService
{
    List<Post> getPostsFromRepo();

    Optional<Post> findPostById(UUID id);

    Post createPost(Post post);

    void deletePost(UUID id);

}
