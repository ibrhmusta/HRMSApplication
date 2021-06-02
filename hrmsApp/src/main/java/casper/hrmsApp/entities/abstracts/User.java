package casper.hrmsApp.entities.abstracts;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")

public abstract class User {

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "uid")
    @JsonIgnore()
    private String uid;

    @Column(name = "email")
    @NotBlank
    @Email
    @JsonIgnore()
    private String email;

    @Column(name = "password")
    @NotBlank
    @JsonIgnore()
    private String password;

    @Column(name = "created_date")
    @NotBlank
    @JsonIgnore()
    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "updated_date")
    @JsonIgnore()
    private LocalDateTime updatedDate;

    @Column(name = "is_deleted",columnDefinition = "boolean default false")
    @JsonIgnore()
    private boolean isDeleted=false;

    @Column(name = "is_activated",columnDefinition = "boolean default true")
    @JsonIgnore()
    private boolean isActivated=true;

}
