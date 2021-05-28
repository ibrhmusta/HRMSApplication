package casper.hrmsApp.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForEmployerDto {
    private String companyName;
    private String webAdress;

    @Pattern(regexp = "^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$",message = "Telefon formatı hatalı...")
    @Size(min=11,max=11,message = "Telefon numarası 11 haneli olmalı")
    private String phoneNumber;

    private String email;
    private String password;
    private String confirmPassword;
}
