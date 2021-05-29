package casper.hrmsApp.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Dto {
    private String email;
    private String password;
    private String confirmPassword;
}
