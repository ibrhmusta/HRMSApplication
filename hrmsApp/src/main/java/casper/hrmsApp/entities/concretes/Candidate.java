package casper.hrmsApp.entities.concretes;

import casper.hrmsApp.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.sql.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@Table(name="candidates")

public class Candidate extends User {

    public Candidate( String firstName, String lastName, String nationalIdentity, Date dateOfBirth, String email, String password)
    {
        super(email,password);
        this.firstName=firstName;
        this.lastName=lastName;
        this.nationalIdentity=nationalIdentity;
        this.dateOfBirth=dateOfBirth;
    }

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="national_identity")
    private String nationalIdentity;

    @Column(name="date_of_birth")
    private Date dateOfBirth;
}
