package casper.hrmsApp.entities.concretes;

import casper.hrmsApp.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends User {

    public Employee(String firstName, String lastName, String email, String password) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

}
