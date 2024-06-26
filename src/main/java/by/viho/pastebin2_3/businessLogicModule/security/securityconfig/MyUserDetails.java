package by.viho.pastebin2_3.businessLogicModule.security.securityconfig;

import by.viho.pastebin2_3.pasteSendingModule.domain.Person;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;



public class MyUserDetails implements UserDetails
{
    private Person person;
    public MyUserDetails(Person person)
    {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return Arrays.stream(person.getRole().toString().split(", "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword()
    {
        return person.getPassword();
    }

    @Override
    public String getUsername()
    {
        return person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}

