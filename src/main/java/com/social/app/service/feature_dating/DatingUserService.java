package com.social.app.service.feature_dating;

import com.social.app.model.ResponseResult;
import com.social.app.model.Status;
import com.social.app.model.feature_dating.DatingCreateProfileRequest;
import com.social.app.model.feature_dating.DatingImage;
import com.social.app.model.feature_dating.DatingUser;
import com.social.app.repository.feature_dating.DatingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DatingUserService {
    @Autowired
    DatingUserRepository repository;

    public List<DatingUser> getAllUser() {
        return repository.findAll();
    }

    public ResponseResult saveDatingProfile(DatingCreateProfileRequest user) {
        DatingUser profile = new DatingUser(0L, user.getProfileId(), user.getName(), LocalDate.parse(user.getDateOfBirth()), user.getBio(), 21.040969, 105.7909658, new ArrayList<>());
        for (int i = 0; i < user.getImagesList().size(); i++) {
            DatingImage datingImage = new DatingImage(user.getImagesList().get(i), new DatingUser(profile.getProfileId()));
            profile.getImagesList().add(datingImage);
        }
        return new ResponseResult(new Status(200, "Successfully"), repository.save(profile));
    }

    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public ResponseResult checkUserExist(String id) {
        Optional<DatingUser> user = repository.findById(id);
        return user.map(datingUser -> new ResponseResult(new Status(200, "Successfully"), datingUser)).orElseGet(() -> new ResponseResult(new Status(200, "Successfully"), null));
    }
}
