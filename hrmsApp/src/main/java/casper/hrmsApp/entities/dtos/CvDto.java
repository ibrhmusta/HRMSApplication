package casper.hrmsApp.entities.dtos;

import casper.hrmsApp.entities.abstracts.Dto;
import casper.hrmsApp.entities.concretes.*;
import ch.qos.logback.core.util.DatePatternToRegexUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto implements Dto {
    private Candidate candidate;
    private List<CandidateEducation> candidateEducations;
    private List<CandidateExperience> candidateExperiences;
    private List<CandidateImage> candidateImages;
    private List<CandidateLanguage> candidateLanguages;
    private List<CandidateLink> candidateLinks;
    private List<CandidateSkill> candidateSkills;
}
