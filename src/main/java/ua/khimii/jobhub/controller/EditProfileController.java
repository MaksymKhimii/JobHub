package ua.khimii.jobhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.khimii.jobhub.entity.Skill;
import ua.khimii.jobhub.form.SkillForm;
import ua.khimii.jobhub.repository.ProfileRepository;
import ua.khimii.jobhub.repository.SkillCategoryRepository;

import javax.validation.Valid;

@Controller
public class EditProfileController {

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String getEditProfile(){
        return "edit";
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
    public String getEditTechSkills(Model model) {
        SkillForm form = new SkillForm(profileRepository.findByUid("richard-hendricks").getSkills());
        model.addAttribute("skillForm", new SkillForm(profileRepository.findByUid("richard-hendricks").getSkills()));

        System.out.println(form);
        return gotoSkillsJSP(model);
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.POST)
    public String saveEditTechSkills(@Valid @ModelAttribute("skillForm") SkillForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return gotoSkillsJSP(model);
        }
        //TODO Update skills
        return "redirect:/mike-ross";
    }

    private String gotoSkillsJSP(Model model){
        model.addAttribute("skillCategories", skillCategoryRepository.findAll(new Sort("id")));
        return "edit/skills";
    }
}