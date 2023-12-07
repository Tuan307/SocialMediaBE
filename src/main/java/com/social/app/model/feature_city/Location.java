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
public class Location {
    @Id
    @Column(name = "city_id")
    Long cityId;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "description")
    private String description;
    @Column(name = "tag")
    private String tag;
    @OneToMany(mappedBy = "location", cascade = {CascadeType.ALL,CascadeType.REMOVE}, orphanRemoval = true)
    private List<LocationImages> locationImages;
    @Column(name = "url")
    private String url;

    public Location(Long id) {
        this.cityId = id;
    }
}
