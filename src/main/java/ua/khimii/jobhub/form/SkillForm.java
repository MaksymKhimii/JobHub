package ua.khimii.jobhub.form;

import ua.khimii.jobhub.entity.Skill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SkillForm implements Serializable {
    private List<Skill> items = new ArrayList<>();

    public SkillForm() {
        super();
    }

    public SkillForm(List<Skill> items) {
        super();
        this.items = items;
    }

    public List<Skill> getItems() {
        return items;
    }

    public void setItems(List<Skill> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SkillForm{" +
                "items=" + items +
                '}';
    }
}