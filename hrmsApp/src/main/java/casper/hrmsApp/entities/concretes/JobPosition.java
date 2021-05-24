package casper.hrmsApp.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

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

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="updated_date")
    private Date updatedDate;

    @Column(name="status")
    private boolean status;
}
