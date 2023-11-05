package com.social.app.repository.feature_post_image;

import com.social.app.model.feature_post_image.PostImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PostImageRepository extends JpaRepository<PostImages, Long> {
}
