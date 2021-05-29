package casper.hrmsApp.entities.concretes;

import casper.hrmsApp.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="activation_codes")
public class ActivationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    //@Column(name="user_id")
    //private int userId;

    @Column(name="uid")
    private String uid;

    @Column(name="activation_code")
    private String activationCode;

    @Column(name="expiration_date")
    private LocalDateTime expirationDate;

    @Column(name="is_confirmed")
    private boolean isConfirmed;

    @Column(name="activation_date")
    private LocalDateTime activationDate;

    @Column(name="created_date")
    private LocalDateTime createdDate= LocalDateTime.now();

    @Column(name= "is_deleted")
    private boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
