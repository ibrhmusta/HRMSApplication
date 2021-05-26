package casper.hrmsApp.entities.abstracts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;


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

    @CreatedDate
    @Column(name="created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name="updated_date")
    private Date updatedDate;

    @Column(name="status")
    private boolean status;
}
