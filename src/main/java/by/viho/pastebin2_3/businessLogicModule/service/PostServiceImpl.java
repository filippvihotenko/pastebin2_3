package by.viho.pastebin2_3.businessLogicModule.service;


import by.viho.pastebin2_3.dataAccessModule.repository.PostRepo;
import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService
{
    private PostRepo postRepo;


    public PostServiceImpl(PostRepo postRepo)
    {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> getPostsFromRepo(){
        return postRepo.findAll();
    }
    @Override
    public Optional<Post> findPostById(UUID id){
        return postRepo.findById(id);
    }

    @Override
    public Post createPost(Post post)
    {
        post.setPost_id(UUID.randomUUID());
        return this.postRepo.save(post);
    }

    @Override
    public void deletePost(UUID id){
        postRepo.deleteById(id);
    }

}



