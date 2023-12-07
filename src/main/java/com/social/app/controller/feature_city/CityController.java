package com.social.app.controller.feature_city;

import com.social.app.model.common.ResponseResult;
import com.social.app.model.feature_city.CityRequest;
import com.social.app.service.feature_city.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/city")
public class CityController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/add")
    public ResponseResult addCity(@RequestBody CityRequest request) {
        return locationService.addCity(request);
    }

    @DeleteMapping("/delete")
    public ResponseResult addCity(@RequestParam("id") Long id) {
        return locationService.deleteCity(id);
    }

    @GetMapping("/search")
    public ResponseResult searchForCity(@RequestParam("keyword") String keyword) {
        return locationService.searchForCity(keyword);
    }

    @GetMapping("/all")
    public ResponseResult getAllCity() {
        return locationService.getAllCity();
    }
}
