package com.social.app.hibernate_mapping_advanced.service;

import com.social.app.hibernate_mapping_advanced.entity.Course;
import com.social.app.hibernate_mapping_advanced.entity.Instructor;
import com.social.app.hibernate_mapping_advanced.repository.CourseRepository;
import com.social.app.hibernate_mapping_advanced.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private InstructorRepository repository;
    private CourseRepository courserepository;

    @Autowired
    public InstructorService(InstructorRepository repository, CourseRepository courseRepository) {
        this.repository = repository;
        this.courserepository = courseRepository;
    }

    public void addInstructor(Instructor instructor) {
        repository.save(instructor);
    }

    public List<Instructor> fetchInstructors() {
        return repository.findAll();
    }

    public List<Course> fetchCourse() {
        return courserepository.findAll();
    }

    public void deleteInstructor() {
        repository.deleteById(3);
    }
}
