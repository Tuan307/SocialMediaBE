package com.social.app.hibernate_mapping_advanced.repository;

import com.social.app.hibernate_mapping_advanced.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
