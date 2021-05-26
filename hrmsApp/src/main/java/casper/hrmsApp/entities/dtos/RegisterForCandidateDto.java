package casper.hrmsApp.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForCandidateDto{
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private Date dateOfBirth;
    private String email;
    private String password;
    private String confirmPassword;
}
