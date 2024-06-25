package by.viho.pastebin2_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
@EnableMethodSecurity
@SpringBootApplication
public class Pastebin23Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Pastebin23Application.class, args);
    }

}
