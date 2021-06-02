package casper.hrmsApp.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="candidate_skills")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @NotNull
    @NotBlank
    @JsonIgnore
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @NotNull
    @NotBlank
    @Column(name="name")
    private String name;

}
