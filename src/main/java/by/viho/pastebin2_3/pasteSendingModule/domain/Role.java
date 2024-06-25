package by.viho.pastebin2_3.pasteSendingModule.domain;

import by.viho.pastebin2_3.pasteSendingModule.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Table(name = "roles")
@Entity
@Getter
@Setter
public class Role {
    @Id
    @Column(name = "uuid",nullable = false)
    private UUID uuid;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @Column(nullable = false)
    private String description;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    public Role() {

    }
}
