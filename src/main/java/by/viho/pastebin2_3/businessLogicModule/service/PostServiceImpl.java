package by.viho.pastebin2_3.businessLogicModule.service;



import by.viho.pastebin2_3.dataAccessModule.repository.PersonRepo;
import by.viho.pastebin2_3.dataAccessModule.repository.PostRepo;
import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService
{
    private PostRepo postRepo;
    private PersonRepo personRepo;
    SecurityContextHolderStrategy strategy =  SecurityContextHolder.getContextHolderStrategy();


    public PostServiceImpl(PostRepo postRepo, PersonRepo personRepo)
    {
        this.personRepo = personRepo;
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
        var userDetails = (UserDetails) this.strategy.getContext().getAuthentication().getPrincipal();

        post.setPost_id(UUID.randomUUID());
        post.setPerson(personRepo.findByUsername(userDetails.getUsername()).orElse(null));

        return this.postRepo.save(post);
    }

    @Override
    public void deletePost(UUID id){
        postRepo.deleteById(id);
    }




    @Override
    public Page<Post> findByTitleContainingIgnoreCase(String keywords, Pageable pageable){
        return postRepo.findByTitleContainingIgnoreCase(keywords,pageable);
    }
    @Override
    public Page<Post> findAll(Pageable pageable){
        return postRepo.findAll(pageable);
    }

}



