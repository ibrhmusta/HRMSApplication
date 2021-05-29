package casper.hrmsApp.entities.abstracts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")

public abstract class User {

    public User(String email, String password){
        this.email = email;
        this.password=password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="uid")
    private String uid;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="created_date")
    private LocalDateTime createdDate= LocalDateTime.now();

    @LastModifiedDate
    @Column(name="updated_date")
    private LocalDateTime updatedDate;

    @Column(name= "is_deleted")
    private boolean isDeleted;

    @Column(name="is_activated")
    private boolean isActivated;

}
