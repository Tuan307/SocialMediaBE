package com.social.app.service.feature_city;

import com.social.app.common.CommonUtils;
import com.social.app.model.common.ResponseResult;
import com.social.app.model.common.Status;
import com.social.app.model.feature_location.Location;
import com.social.app.model.feature_location.LocationImages;
import com.social.app.model.feature_location.LocationRequest;
import com.social.app.repository.feature_city.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public ResponseResult addCity(LocationRequest request) {
        Location location = new Location(request.getCityId(), request.getCityName(), request.getDescription(), request.getTag(), new ArrayList<>(), null);
        for (int i = 0; i < request.getCityImages().size(); i++) {
            LocationImages locationImages = new LocationImages(0L, request.getCityImages().get(i), new Location(request.getCityId()));
            location.getLocationImages().add(locationImages);
        }
        Location result = locationRepository.save(location);
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), result);
    }

    public ResponseResult searchForCity(String keyword) {
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), locationRepository.searchCityByName(keyword));
    }

    public ResponseResult deleteCity(Long id) {
        locationRepository.deleteById(String.valueOf(id));
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), null);
    }

    public ResponseResult getAllCity() {
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), locationRepository.findAll());
    }
}
