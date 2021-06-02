package casper.hrmsApp.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="candidate_images")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


    @Column(name="url")
    private String url;

    @Column(name="uploaded_date")
    private LocalDateTime uploadedDate;
}
