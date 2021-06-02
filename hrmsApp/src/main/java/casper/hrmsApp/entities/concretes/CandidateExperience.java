package casper.hrmsApp.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name="candidate_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name = "position")
    @NotNull
    @NotBlank
    private String position;

    @Column(name = "start_date")
    @NotNull
    private LocalDate startDate;

    @Column(name = "leave_date")
    private LocalDate leaveDate;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
