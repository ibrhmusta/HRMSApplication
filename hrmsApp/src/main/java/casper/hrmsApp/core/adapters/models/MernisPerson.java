package casper.hrmsApp.core.adapters.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MernisPerson {
    private String firstName;
    private String lastName;
    private String identificationNumber;
    private Date birthYear;
}
