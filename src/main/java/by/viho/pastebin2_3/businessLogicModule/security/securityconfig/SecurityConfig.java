package by.viho.pastebin2_3.businessLogicModule.security.securityconfig;/*
package by.viho.pastebin2.businessLogicModule.security.securityconfig;

import by.viho.pastebin2.dataAccessModule.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig
{

    private final PersonRepo personRepo;

    @Autowired
    public SecurityConfig(PersonRepo personRepo)
    {
        this.personRepo = personRepo;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new MyUserDetailService(personRepo);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder(5);
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf().disable();
        return http.authorizeHttpRequests(authorizeRequest -> authorizeRequest.requestMatchers("/test/index")
                        .permitAll().anyRequest().authenticated()).build();
    }

}
*/