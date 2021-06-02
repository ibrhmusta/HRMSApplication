package casper.hrmsApp.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="candidate_languages")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "level")
    @Min(1)
    @Max(5)
    @NotNull
    private short level;

    @ManyToOne()
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
