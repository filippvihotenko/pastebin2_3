package by.viho.pastebin2_3.businessLogicModule.service;/*
package by.viho.pastebin2.dataAccessModule.service;

import by.viho.pastebin2.dataAccessModule.repository.PersonRepo;
import by.viho.pastebin2.pasteSendingModule.domain.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService
{


    private final PersonRepo personRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationService(PersonRepo personRepo, PasswordEncoder passwordEncoder)
    {
        this.personRepo = personRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        personRepo.save(person);
    }
}
*/
