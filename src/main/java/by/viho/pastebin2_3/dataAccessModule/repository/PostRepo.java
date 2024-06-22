package by.viho.pastebin2_3.dataAccessModule.repository;


import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepo extends JpaRepository<Post,UUID>
{
    Page<Post> findByTitleContainingIgnoreCase(String keywords, Pageable pageable);
    List<Post> findAll(Sort sort);

    Page<Post> findAll(Pageable pageable);
}
