package by.viho.pastebin2_3.dataAccessModule.repository;

import by.viho.pastebin2_3.pasteSendingModule.domain.Role;
import by.viho.pastebin2_3.pasteSendingModule.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(RoleEnum name);
}
