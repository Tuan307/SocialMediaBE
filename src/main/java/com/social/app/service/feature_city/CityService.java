package com.social.app.service.feature_city;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.common.Status;
import com.social.app.model.feature_city.City;
import com.social.app.model.feature_city.CityImages;
import com.social.app.model.feature_city.CityRequest;
import com.social.app.repository.feature_city.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public ResponseResult addCity(CityRequest request) {
        City city = new City(request.getCityId(), request.getCityName(), request.getDescription(), request.getTag(), new ArrayList<>());
        for (int i = 0; i < request.getCityImages().size(); i++) {
            CityImages cityImages = new CityImages(0L, request.getCityImages().get(i), new City(request.getCityId()));
            city.getCityImages().add(cityImages);
        }
        City result = cityRepository.save(city);
        return new ResponseResult(new Status(200, "Successfully"), result);
    }

    public ResponseResult getAllCity() {
        return new ResponseResult(new Status(200, "Successfully"), cityRepository.findAll());
    }
}
