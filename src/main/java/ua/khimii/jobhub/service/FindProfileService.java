package ua.khimii.jobhub.service;

import ua.khimii.jobhub.entity.Profile;

public interface FindProfileService {
    Profile findByUid(String uid);
}
