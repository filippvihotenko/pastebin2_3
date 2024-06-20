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
    private UUID uuid;
    @Column(unique = true)
    private String username;
    private String password;
    private String role;

    public Person()
    {
        this.uuid = UUID.randomUUID();
    }
}
