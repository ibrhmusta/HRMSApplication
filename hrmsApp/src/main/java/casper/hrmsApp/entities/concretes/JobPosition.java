package casper.hrmsApp.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_positions")

public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="uid")
    private String uid;

    @Column(name="title")
    private String title;

    @Column(name="created_date")
    private LocalDateTime createdDate= LocalDateTime.now();

    @Column(name="updated_date")
    private LocalDateTime updatedDate;

    @Column(name="status")
    private boolean status;
}
