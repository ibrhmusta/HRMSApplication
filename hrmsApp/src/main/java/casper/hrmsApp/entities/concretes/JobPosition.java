package casper.hrmsApp.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name= "is_deleted")
    private boolean isDeleted;

    @Column(name="is_activated")
    private boolean isActivated;

    @OneToMany(mappedBy = "jobPosition")
    private List<JobPost> jobPosts;

}
