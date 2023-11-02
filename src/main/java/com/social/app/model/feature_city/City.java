package com.social.app.model.feature_city;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    Long cityId;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "description")
    private String description;
    @Column(name = "tag")
    private String tag;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CityImages> cityImages;

    public City(Long id) {
        this.cityId = id;
    }
}
