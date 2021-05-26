package casper.hrmsApp.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForEmployerDto {
    private String companyName;
    private String webAdress;
    private String phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;
}
