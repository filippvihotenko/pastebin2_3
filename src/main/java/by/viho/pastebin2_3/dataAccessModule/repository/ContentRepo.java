package by.viho.pastebin2_3.dataAccessModule.repository;


import by.viho.pastebin2_3.pasteSendingModule.domain.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContentRepo extends MongoRepository<Content, UUID>
{
}
