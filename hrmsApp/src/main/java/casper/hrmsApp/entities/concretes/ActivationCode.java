package casper.hrmsApp.entities.concretes;

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
@Table(name="activation_codes")
public class ActivationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="uid")
    private String uid;

    @Column(name="activation_code")
    private String activationCode;

    @Column(name="expration_date")
    private Date exprationDate;

    @Column(name="is_confirmed")
    private boolean isConfirmed;

    @Column(name="activation_date")
    private Date activationDate;

    @CreatedDate
    @Column(name="created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name="updated_date")
    private Date updatedDate;

    @Column(name="status")
    private boolean status;

}
