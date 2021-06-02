package casper.hrmsApp.entities.concretes;

import casper.hrmsApp.entities.abstracts.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "candidates")
public class Candidate extends User {

    public Candidate(String firstName, String lastName, String nationalIdentity, Date dateOfBirth,
                     String email, String password, String description) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.dateOfBirth = dateOfBirth;
        this.description = description;
    }

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Column(name = "national_identity")
    @NotBlank
    @JsonIgnore()
    private String nationalIdentity;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "description")
    @NotBlank
    private String description;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateEducation> candidateEducations;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateImage> candidateImages;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateExperience> candidateExperiences;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateLanguage> candidateLanguages;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateLink> candidateLinks;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateSkill> candidateSkills;

}

