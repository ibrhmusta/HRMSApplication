package casper.hrmsApp.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="job_positions")

public class JobPosition {

    public JobPosition(String position) {
        super();
        this.position = position;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="title")
    private String position;
}
