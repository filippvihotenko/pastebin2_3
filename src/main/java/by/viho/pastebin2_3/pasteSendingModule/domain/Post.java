package by.viho.pastebin2_3.pasteSendingModule.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Post")

public class Post
{
    @Id
    @Column(name = "post_Id")
    private UUID post_id;

    @Column(name = "timestamp")
    private ZonedDateTime created_at;

    @Column(name = "cathegory")
    @NotNull
    private String cathegory;

    @Column(name = "message")
    @NotNull
    @Size(min = 1, max = 1000)
    private String message;

    @Column(name = "title")
    @NotNull
    @Size(min = 1, max = 30)
    private String title;

    @Column(name = "paste_exposure")
    @NotNull
    private String paste_exposure;


    @Column(name = "paste_expiration")
    @NotNull
    private String paste_expiration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "username")
    private Person person;
}
