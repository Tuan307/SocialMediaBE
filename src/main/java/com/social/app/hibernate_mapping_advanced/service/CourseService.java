package com.social.app.hibernate_mapping_advanced.service;

import com.social.app.hibernate_mapping_advanced.entity.Course;
import com.social.app.hibernate_mapping_advanced.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void deleteCourse(int id) {
        Optional<Course> course = courseRepository.findById(id);
        course.ifPresent(value -> courseRepository.delete(value));
    }
}
