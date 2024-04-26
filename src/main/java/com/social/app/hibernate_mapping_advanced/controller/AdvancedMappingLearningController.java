package com.social.app.hibernate_mapping_advanced.controller;

import com.social.app.hibernate_mapping_advanced.entity.Course;
import com.social.app.hibernate_mapping_advanced.entity.Instructor;
import com.social.app.hibernate_mapping_advanced.entity.InstructorDetail;
import com.social.app.hibernate_mapping_advanced.service.CourseService;
import com.social.app.hibernate_mapping_advanced.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/hibernate")
public class AdvancedMappingLearningController {

    private InstructorService instructorService;
    private CourseService courseService;

    @Autowired
    public AdvancedMappingLearningController(InstructorService instructorService, CourseService courseService) {
        this.instructorService = instructorService;
        this.courseService = courseService;
    }

    @PostMapping("/instructor/add")
    public void addInstructor() {
        Instructor instructor = new Instructor();
        instructor.setId(0);
        instructor.setInstructorDetail(new InstructorDetail(0, "", "", instructor));
        instructor.setEmail("tp@gmail.com");
        instructor.setLastName("tp@gmail.com");
        instructor.setFirstName("tp@gmail.com");
        Course course = new Course(0, "a", instructor);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course);
        instructor.setCourseList(courses);
        instructorService.addInstructor(instructor);
    }

    @GetMapping("/instructor")
    public List<Instructor> fetchInstructorData() {
        return instructorService.fetchInstructors();
    }

    @GetMapping("/course")
    public List<Course> fetchCourseData() {
        return instructorService.fetchCourse();
    }

    @DeleteMapping("/delete/course")
    public String deleteCourse() {
        courseService.deleteCourse(1);
        return "Yeah";
    }

    @DeleteMapping("/delete/instructor")
    public String deleteInstructor() {
        instructorService.deleteInstructor();
        return "Yeah123";
    }
}
