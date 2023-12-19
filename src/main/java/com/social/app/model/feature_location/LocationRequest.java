package com.social.app.model.feature_location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {
    private Long cityId;
    private String cityName;
    private String description;
    private String tag;
    private String webUrl;
    private List<String> cityImages;
}
