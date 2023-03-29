package ua.khimii.jobhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.khimii.jobhub.entity.Profile;
import ua.khimii.jobhub.repository.ProfileRepository;
import ua.khimii.jobhub.service.FindProfileService;

@Service
public class FindProfileServiceImpl implements FindProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile findByUid(String uid) {
        return profileRepository.findByUid(uid);
    }
}