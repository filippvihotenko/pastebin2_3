package by.viho.pastebin2_3.businessLogicModule.service;

import by.viho.pastebin2_3.dataAccessModule.repository.PersonRepo;
import by.viho.pastebin2_3.dataAccessModule.repository.PostRepo;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.domain.Person;
import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class MyPastesServiceImpl implements MyPastesService {


    public MyPastesServiceImpl(PostRepo postRepo, PersonRepo personRepo) {
        this.postRepo = postRepo;
        this.personRepo = personRepo;
    }

    private PostRepo postRepo;

    private PersonRepo personRepo;
    SecurityContextHolderStrategy strategy =  SecurityContextHolder.getContextHolderStrategy();

    @Override
    public Page<PostDTO> findPostsBySenderIdIgnoreCase(Pageable pageable) {
        UserDetails userDetails = (UserDetails) strategy.getContext().getAuthentication().getPrincipal();
        Person person = personRepo.findByUsername(userDetails.getUsername()).orElse(null);
        return postRepo.findPostBySenderId(person.getUsername(), person ,pageable);
    }

    @Override
    public Page<PostDTO> findPostsBySenderIdIgnoreCaseWithKeyword (Pageable pageable, String keyword) {
        UserDetails userDetails = (UserDetails) strategy.getContext().getAuthentication().getPrincipal();
        Person person = personRepo.findByUsername(userDetails.getUsername()).orElse(null);
        return postRepo.findPostBySenderIdContainingIgnoreCase(userDetails.getUsername(),person, pageable, keyword);
    }

    @Override
    public void dislikePost(UUID post_id){
        UserDetails userDetails = (UserDetails) strategy.getContext().getAuthentication().getPrincipal();
        Person person1 = personRepo.findByUsername(userDetails.getUsername()).orElse(null);

       Optional<Post> post =  postRepo.findById(post_id);
       if(post.isPresent()){
           Post post1 =  post.get();
           post1.getPersonSet().removeIf(person -> person.getUsername().contentEquals(person1.getUsername()));
           postRepo.save(post1);
       }
    }

    @Override
    public void likePost(UUID post_id) {
        UserDetails userDetails = (UserDetails) strategy.getContext().getAuthentication().getPrincipal();
        Person person1 = personRepo.findByUsername(userDetails.getUsername()).orElse(null);

        if (person1 != null) {
            Optional<Post> optionalPost = postRepo.findById(post_id);
            optionalPost.ifPresent(post1 -> {
                post1.getPersonSet().add(person1);
                postRepo.save(post1);
            });
        }
    }
}
