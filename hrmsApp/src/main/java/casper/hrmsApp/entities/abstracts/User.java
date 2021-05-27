package casper.hrmsApp.entities.abstracts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
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

    @Column(name="status")
    private boolean status;
}
