package ua.khimii.jobhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.khimii.jobhub.entity.SkillCategory;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
}
