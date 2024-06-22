package by.viho.pastebin2_3.pasteSendingModule.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;
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

    @OneToMany(mappedBy = "person",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts;

    public Person()
    {
        this.uuid = UUID.randomUUID();
    }
}
