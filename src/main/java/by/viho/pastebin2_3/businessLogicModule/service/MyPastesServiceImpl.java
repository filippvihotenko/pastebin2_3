package by.viho.pastebin2_3.businessLogicModule.service;

import by.viho.pastebin2_3.dataAccessModule.repository.PostRepo;
import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class MyPastesServiceImpl implements MyPastesService {


    public MyPastesServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    private PostRepo postRepo;
    SecurityContextHolderStrategy strategy =  SecurityContextHolder.getContextHolderStrategy();

    @Override
    public Page<Post> findPostsBySenderIdIgnoreCase(Pageable pageable) {
        UserDetails userDetails = (UserDetails) strategy.getContext().getAuthentication().getPrincipal();
        Page<Post> page = postRepo.findPostBySenderIdNative(userDetails.getUsername(), pageable);
        page.getContent().forEach(post -> log.info(post.toString()));
        return postRepo.findPostBySenderIdNative(userDetails.getUsername(), pageable);
    }

    @Override
    public Page<Post> findPostsBySenderIdIgnoreCaseWithKeyword (Pageable pageable, String keyword) {
        UserDetails userDetails = (UserDetails) strategy.getContext().getAuthentication().getPrincipal();

        return postRepo.findPostBySenderIdNativeWithKeyword(userDetails.getUsername(), pageable, keyword);
    }



}
