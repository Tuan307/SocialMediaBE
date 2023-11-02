package com.social.app.controller.feature_city;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.feature_city.CityRequest;
import com.social.app.service.feature_city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/add")
    public ResponseResult addCity(@RequestBody CityRequest request) {
        return cityService.addCity(request);
    }

    @GetMapping("/all")
    public ResponseResult getAllCity() {
        return cityService.getAllCity();
    }
}
