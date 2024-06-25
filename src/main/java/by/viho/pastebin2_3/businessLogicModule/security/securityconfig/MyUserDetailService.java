package by.viho.pastebin2_3.businessLogicModule.security.securityconfig;

import by.viho.pastebin2_3.dataAccessModule.repository.PersonRepo;
import by.viho.pastebin2_3.pasteSendingModule.domain.Person;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailService implements UserDetailsService
{
    private PersonRepo personRepo;


    public MyUserDetailService(PersonRepo personRepo)
    {
        this.personRepo = personRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<Person> person = personRepo.findByUsername(username);

        return person.map(MyUserDetails::new).orElseThrow(()-> new UsernameNotFoundException(username + "There is not such user"));
    }
}

