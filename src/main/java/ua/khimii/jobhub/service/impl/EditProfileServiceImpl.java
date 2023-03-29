package ua.khimii.jobhub.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.khimii.jobhub.entity.Profile;
import ua.khimii.jobhub.entity.Skill;
import ua.khimii.jobhub.entity.SkillCategory;
import ua.khimii.jobhub.exception.CantCompleteClientRequestException;
import ua.khimii.jobhub.form.SignUpForm;
import ua.khimii.jobhub.repository.ProfileRepository;
import ua.khimii.jobhub.repository.SkillCategoryRepository;
import ua.khimii.jobhub.service.EditProfileService;
import ua.khimii.jobhub.util.DataUtil;

import java.util.List;

@Service
public class EditProfileServiceImpl implements EditProfileService {
    protected final Logger LOGGER = Logger.getLogger(getClass());
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @Value("${generate.uid.suffix.length}")
    private int generateUidSuffixLength;

    @Value("${generate.uid.alphabet}")
    private String generateUidAlphabet;

    @Value("${generate.uid.max.try.count}")
    private int maxTryCountToGenerateUid;

    @Override
    @Transactional
    public Profile createNewProfile(SignUpForm signUpForm) {
        Profile profile = new Profile();
        profile.setUid(generateProfileUid(signUpForm));
        profile.setFirstName(DataUtil.capitalizeName(signUpForm.getFirstName()));
        profile.setLastName(DataUtil.capitalizeName(signUpForm.getLastName()));
        profile.setPassword(signUpForm.getPassword());
        profile.setCompleted(false);
        profileRepository.save(profile);
        return profile;
    }

    private String generateProfileUid(SignUpForm signUpForm) throws CantCompleteClientRequestException {
        String baseUid = DataUtil.generateProfileUid(signUpForm);
        String uid = baseUid;
        for (int i = 0; profileRepository.countByUid(uid) > 0; i++) {
            uid = DataUtil.regenerateUidWithRandomSuffix(baseUid, generateUidAlphabet, generateUidSuffixLength);
            if (i >= maxTryCountToGenerateUid) {
                throw new CantCompleteClientRequestException("Can't generate unique uid for profile: " + baseUid+": maxTryCountToGenerateUid detected");
            }
        }
        return uid;
    }

    @Override
    public List<Skill> listSkills(long idProfile) {
        return profileRepository.findByUid(String.valueOf(idProfile)).getSkills();
    }

    @Override
    public List<SkillCategory> listSkillCategories() {
        return skillCategoryRepository.findAll(new Sort("id"));
    }

    @Override
    @Transactional
    public void updateSkills(long idProfile, List<Skill> updatedData) {
        Profile profile = profileRepository.findByUid(String.valueOf(idProfile));
        if (CollectionUtils.isEqualCollection(updatedData, profile.getSkills())) {
            LOGGER.debug("Profile skills: nothing to update");
            return;
        } else {
            profile.setSkills(updatedData);
            profileRepository.save(profile);
        }
    }
}