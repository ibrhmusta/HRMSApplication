package casper.hrmsApp.entities.abstracts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")

public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

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
