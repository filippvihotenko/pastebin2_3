package by.viho.pastebin2_3.pasteSendingModule.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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

    @Column(name = "sender_Id")
    private UUID sender_id;

    @Column(name = "timestamp")
    private ZonedDateTime created_at;

    @Column(name = "cathegory")
    private String cathegory;

    @Column(name = "message")
    @NotNull
    private String message;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "paste_exposure")
    @NotNull
    private String paste_exposure;


    @Column(name = "paste_expiration")
    @NotNull
    private String paste_expiration;
}
