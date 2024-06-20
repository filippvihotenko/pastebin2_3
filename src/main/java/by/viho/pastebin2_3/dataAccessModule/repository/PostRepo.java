package by.viho.pastebin2_3.dataAccessModule.repository;


import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepo extends JpaRepository<Post,UUID>
{
}
