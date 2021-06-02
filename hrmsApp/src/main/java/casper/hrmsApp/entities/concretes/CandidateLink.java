package casper.hrmsApp.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="candidate_links")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "link")
    private String link;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne()
    @JoinColumn(name = "link_id")
    private LinkType linkType;
}
