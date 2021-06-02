package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.*;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.entities.concretes.*;
import casper.hrmsApp.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvManager implements CvService{
    private final CandidateService candidateService;
    private final CandidateEducationService candidateEducationService;
    private final CandidateExperienceService candidateExperienceService;
    private final CandidateImageService candidateImageService;
    private final CandidateLanguageService candidateLanguageService;
    private final CandidateLinkService candidateLinkService;
    private final CandidateSkillService candidateSkillService;

    @Autowired
    public CvManager(CandidateService candidateService, CandidateEducationService candidateEducationService, CandidateExperienceService candidateExperienceService,
                        CandidateImageService candidateImageService, CandidateLanguageService candidateLanguageService, CandidateLinkService candidateLinkService, CandidateSkillService candidateSkillService) {
        this.candidateService = candidateService;
        this.candidateEducationService = candidateEducationService;
        this.candidateExperienceService = candidateExperienceService;
        this.candidateImageService = candidateImageService;
        this.candidateLanguageService = candidateLanguageService;
        this.candidateLinkService = candidateLinkService;
        this.candidateSkillService = candidateSkillService;
    }

    @Override
    public Result add(CvDto cvDto, int candidateId) {
        Candidate candidate = candidateService.getById(candidateId).getData();
        cvDto.setCandidate(candidate);

        cvDto.getCandidateEducations().forEach(candidateEducation -> candidateEducation.setCandidate(candidate));
        candidateEducationService.addAll(cvDto.getCandidateEducations());

        cvDto.getCandidateExperiences().forEach(candidateExperience -> candidateExperience.setCandidate(candidate));
        candidateExperienceService.addAll(cvDto.getCandidateExperiences());

        cvDto.getCandidateImages().forEach(candidateImage -> candidateImage.setCandidate(candidate));
        candidateImageService.addAll(cvDto.getCandidateImages());

        cvDto.getCandidateLanguages().forEach(candidateLanguage -> candidateLanguage.setCandidate(candidate));
        candidateLanguageService.addAll(cvDto.getCandidateLanguages());

        cvDto.getCandidateLinks().forEach(candidateLink -> candidateLink.setCandidate(candidate));
        candidateLinkService.addAll(cvDto.getCandidateLinks());

        cvDto.getCandidateSkills().forEach(candidateSkill -> candidateSkill.setCandidate(candidate));
        candidateSkillService.addAll(cvDto.getCandidateSkills());

        return new SuccessResult(Messages.CvAdded);
    }
}
