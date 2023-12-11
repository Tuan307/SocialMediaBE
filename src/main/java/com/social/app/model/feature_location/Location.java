package com.social.app.model.feature_location;

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
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "id")
    Long cityId;
    @Column(name = "name")
    private String cityName;
    @Column(name = "description")
    private String description;
    @Column(name = "tag")
    private String tag;
    @OneToMany(mappedBy = "location", cascade = {CascadeType.ALL,CascadeType.REMOVE}, orphanRemoval = true)
    private List<LocationImages> locationImages;
    @Column(name = "web_url")
    private String url;

    public Location(Long id) {
        this.cityId = id;
    }
}
