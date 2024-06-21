package by.viho.pastebin2_3.pasteSendingModule.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Person")
public class Person
{

    @Id
    @Column(name = "uuid", unique = true)
    private UUID uuid;
    @Column(name = "username",unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    public Person()
    {
        this.uuid = UUID.randomUUID();
    }
}
