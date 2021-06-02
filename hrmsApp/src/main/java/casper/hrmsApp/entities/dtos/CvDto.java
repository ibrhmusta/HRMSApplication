package casper.hrmsApp.entities.dtos;

import casper.hrmsApp.entities.abstracts.Dto;
import casper.hrmsApp.entities.concretes.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto implements Dto {
    @JsonIgnore
    private Candidate candidate;
    private List<@Valid CandidateEducation> candidateEducations;
    private List<@Valid CandidateExperience> candidateExperiences;
    private List<@Valid CandidateImage> candidateImages;
    private List<@Valid CandidateLanguage> candidateLanguages;
    private List<@Valid CandidateLink> candidateLinks;
    private List<@Valid CandidateSkill> candidateSkills;
}
