package casper.hrmsApp.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job_posts")
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "uid")
    private String uid;
    //@Column(name = "employer_id")
    //private int employerId;
    //@Column(name = "job_position_id")
    //private int jobPositionId;
    //@Column(name = "city_id")
    //private int cityId;
    @Column(name = "description")
    private String description;
    @Column(name = "min_salary")
    private double minSalary;
    @Column(name = "max_salary")
    private double maxSalary;
    @Column(name = "quota")
    private int quota;
    @Column(name = "appeal_deadline")
    private LocalDate appealDeadline;
    @Column(name = "created_date")
    private LocalDateTime createdDate=LocalDateTime.now();
    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Column(name = "is_activated")
    private boolean isActivated;

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name="employer_id")
    private Employer employer;

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition;

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name="city_id")
    private City city;

}
