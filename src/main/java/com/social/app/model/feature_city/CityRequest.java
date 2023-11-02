package com.social.app.model.feature_city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityRequest {
    private Long cityId;
    private String cityName;
    private String description;
    private String tag;
    private List<String> cityImages;
}
