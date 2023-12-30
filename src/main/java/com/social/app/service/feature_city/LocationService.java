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
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public ResponseResult addCity(LocationRequest request) {
        Location location = new Location(0L, request.getCityName(), request.getDescription(), request.getTag(), new ArrayList<>(), request.getWebUrl());
        for (int i = 0; i < request.getCityImages().size(); i++) {
            LocationImages locationImages = new LocationImages(0L, request.getCityImages().get(i), location);
            location.getLocationImages().add(locationImages);
        }
        Location result = locationRepository.save(location);
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), result);
    }

    public ResponseResult updateLocation(LocationRequest request) {
        Optional<Location> location = locationRepository.findById(String.valueOf(request.getCityId()));
        if (location.isPresent()) {
            Location model = location.get();
            if (!request.getTag().equals("")) {
                model.setTag(request.getTag());
            }
            if (!request.getDescription().equals("")) {
                model.setDescription(request.getDescription());
            }
            if (!request.getCityName().equals("")) {
                model.setCityName(request.getCityName());
            }
            if (!request.getWebUrl().equals("")) {
                model.setUrl(request.getWebUrl());
            }
            return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), locationRepository.save(model));
        } else {
            return new ResponseResult(new Status(200, CommonUtils.LOCATION_EXIST_ERROR_RESPONSE), null);
        }
    }

    public ResponseResult searchForCity(String keyword) {
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), locationRepository.searchCityByName(keyword));
    }

    public ResponseResult getLocation(Long id) {
        Optional<Location> location = locationRepository.findById(String.valueOf(id));
        return location.map(value -> new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), value)).orElseGet(() -> new ResponseResult(new Status(200, CommonUtils.LOCATION_EXIST_ERROR_RESPONSE), null));
    }

    public ResponseResult deleteCity(Long id) {
        locationRepository.deleteById(String.valueOf(id));
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), null);
    }

    public ResponseResult getAllCity() {
        return new ResponseResult(new Status(200, CommonUtils.SUCCESSFULLY_RESPONSE), locationRepository.findAll());
    }
}
