package by.viho.pastebin2_3.dataAccessModule.repository;


import by.viho.pastebin2_3.pasteSendingModule.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepo extends JpaRepository<Person, UUID>
{
    Optional<Person> findByUsername(String username);
}
