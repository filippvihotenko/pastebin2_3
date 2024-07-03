package by.viho.pastebin2_3.businessLogicModule.service;

import by.viho.pastebin2_3.dataAccessModule.repository.PersonRepo;
import by.viho.pastebin2_3.dataAccessModule.repository.RoleRepository;
import by.viho.pastebin2_3.pasteSendingModule.DTO.PersonDTO;
import by.viho.pastebin2_3.pasteSendingModule.domain.Person;
import by.viho.pastebin2_3.pasteSendingModule.domain.Role;
import by.viho.pastebin2_3.pasteSendingModule.enums.RoleEnum;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserRegistrationService
{

    private final PersonRepo personRepo;
    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepo;


    public Person signUpUser(PersonDTO personDTO){
        Optional<Role> role = roleRepo.findByName(RoleEnum.ADMIN);

        if (role.isEmpty()){
            return null;
        }
        var person = new Person();
        person.setUsername(personDTO.getUsername());
        person.setPassword(passwordEncoder.encode(personDTO.getPassword()));
        person.setPosts(null);
        person.setRole("ROLE_" + role.get().getName().toString());
        person.setUuid(UUID.randomUUID());
        return personRepo.save(person);
    }
}