package ua.khimii.jobhub.repository;

import org.springframework.data.repository.CrudRepository;
import ua.khimii.jobhub.entity.ProfileRestore;

public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore, Long> {

    ProfileRestore findByToken(String token);
}