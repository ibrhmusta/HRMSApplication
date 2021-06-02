package casper.hrmsApp.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="link_types")
public class LinkType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="type")
    private String type;

    @OneToMany(mappedBy = "linkType")
    @JsonIgnore()
    private List<CandidateLink> candidateLinks;
}
