package com.social.app.repository.feature_city;

import com.social.app.model.feature_city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    @Query(value = "SELECT p FROM City p WHERE p.cityName LIKE %?1%")
    List<City> searchCityByName(String keyword);
}
