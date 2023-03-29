package ua.khimii.jobhub.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.khimii.jobhub.entity.Profile;

public interface FindProfileService {
    Profile findByUid(String uid);
    Page<Profile> findAll(Pageable pageable);
}
