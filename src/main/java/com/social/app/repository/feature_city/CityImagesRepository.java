package com.social.app.repository.feature_city;

import com.social.app.model.feature_city.CityImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityImagesRepository extends JpaRepository<CityImages,Long> {
}
