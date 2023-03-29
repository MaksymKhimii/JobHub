package ua.khimii.jobhub.service;

import ua.khimii.jobhub.entity.Profile;
import ua.khimii.jobhub.entity.Skill;
import ua.khimii.jobhub.entity.SkillCategory;
import ua.khimii.jobhub.form.SignUpForm;

import java.util.List;

public interface EditProfileService {
    Profile createNewProfile(SignUpForm signUpForm);

    List<Skill> listSkills(long idProfile);

    List<SkillCategory> listSkillCategories();

    void updateSkills(long idProfile, List<Skill> skills);
}
