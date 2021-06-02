package casper.hrmsApp.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class DtoForAuth {

    @Email
    private String email;
    private String password;
    private String confirmPassword;
}
