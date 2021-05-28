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
import javax.validation.constraints.Pattern;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@Table(name="employers")
public class Employer extends User {

    public Employer( String companyName,String webAdress,String phoneNumber,String email,String password){
        super(email,password);
        this.companyName=companyName;
        this.webAddress=webAdress;
        this.phoneNumber=phoneNumber;
    }

    @Column(name="company_name")
    private String companyName;

    @Column(name="web_address")
    private String webAddress;

    @Column(name="phone_number")
    private String phoneNumber;
}
