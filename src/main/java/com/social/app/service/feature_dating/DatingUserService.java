package com.social.app.service.feature_dating;

//@Service
public class DatingUserService {
//    @Autowired
//    DatingUserRepository repository;
//
//    public DatingUser getDetailUser(String profileId) {
//        return repository.findUserByProfileId(profileId).get();
//    }
//
//    public ResponseResult getAllUser() {
//        return new ResponseResult(new Status(200, "Successfully"), repository.findAll());
//    }
//
//    public ResponseResult saveDatingProfile(DatingCreateProfileRequest user) {
//        DatingUser profile = new DatingUser(user.getProfileId(), user.getName(), LocalDate.parse(user.getDateOfBirth()), user.getBio(), 21.040969, 105.7909658, new ArrayList<>());
//        for (int i = 0; i < user.getImagesList().size(); i++) {
//            DatingImage datingImage = new DatingImage(user.getImagesList().get(i), new DatingUser(user.getProfileId()));
//            profile.getImagesList().add(datingImage);
//        }
//        return new ResponseResult(new Status(200, "Successfully"), repository.save(profile));
//    }
//
//    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
//        if ((birthDate != null) && (currentDate != null)) {
//            return Period.between(birthDate, currentDate).getYears();
//        } else {
//            return 0;
//        }
//    }
//
//    public ResponseResult checkUserExist(String profileId) {
//        Optional<DatingUser> user = repository.findUserByProfileId(profileId);
//        return user.map(datingUser -> new ResponseResult(new Status(200, "Successfully"), datingUser)).orElseGet(() -> new ResponseResult(new Status(200, "Successfully"), null));
//    }
//
}