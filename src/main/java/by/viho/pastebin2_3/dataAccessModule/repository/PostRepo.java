package by.viho.pastebin2_3.dataAccessModule.repository;


import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepo extends JpaRepository<Post,UUID>
{
    Page<Post> findByTitleContainingIgnoreCase(String keywords, Pageable pageable);
    List<Post> findAll(Sort sort);

    Page<Post> findAll(Pageable pageable);


    @Query(value = "SELECT * FROM Post p WHERE p.sender_id = :sender_Id",
            nativeQuery = true)
    Page<Post> findPostBySenderIdNative(String sender_Id, Pageable pageable);

    @Query(value = "SELECT * FROM Post p WHERE p.sender_id = :sender_Id AND p.content ILIKE %:keyword%",
            nativeQuery = true)
    Page<Post> findPostBySenderIdNativeWithKeyword(String sender_Id, Pageable pageable, String keyword);

}
