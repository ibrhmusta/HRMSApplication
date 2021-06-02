package casper.hrmsApp.entities.dtos;


import casper.hrmsApp.entities.abstracts.DtoForAuth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForCandidateDtoForAuth extends DtoForAuth {

    @Size(min = 2, message = "İsminiz iki karakterden küçük olamaz")
    private String firstName;

    @Size(min = 2, message = "Soyisminiz iki karakterden küçük olamaz")
    private String lastName;

    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = "Kimlik numarası çift sayı ile bitmeli")
    private String nationalIdentity;
    private Date dateOfBirth;
    private String description;
}
