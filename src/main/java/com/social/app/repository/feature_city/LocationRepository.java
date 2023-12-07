package com.social.app.repository.feature_city;

import com.social.app.model.feature_city.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    @Query(value = "SELECT p FROM Location p WHERE p.cityName LIKE %?1%")
    List<Location> searchCityByName(String keyword);
}
