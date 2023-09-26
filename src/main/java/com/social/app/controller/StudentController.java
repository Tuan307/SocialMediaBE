package com.social.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

//    @Autowired
//    StudentService studentService;
//
//    @GetMapping()
//    public List<Student> getStudents() {
//        return studentService.getStudents();
//    }
//
//    @PostMapping()
//    public ResponseResult saveStudent(@RequestBody Student student) {
//        return studentService.saveStudents(student);
//    }
//
//    @DeleteMapping(path = "delete")
//    public ResponseResult deleteStudent(@RequestParam("studentId") Long studentId) {
//        return studentService.deleteStudent(studentId);
//    }
//
//    @PutMapping(path = "update")
//    public ResponseResult updateStudent(@RequestParam("id") Long id, @RequestBody Student student) {
//        return studentService.updateStudent(id, student);
//    }
}
