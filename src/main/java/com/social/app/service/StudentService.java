package com.social.app.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
//    @Autowired
//    private StudentRepository repository;
//
//    public List<Student> getStudents() {
//        return repository.findAll();
//    }
//
//    public ResponseResult saveStudents(Student student) {
//        Optional<Student> checkStudentExistence = repository.findStudentByEmail(student.getEmail());
//        if (checkStudentExistence.isPresent()) {
//            return new ResponseResult(200, "Email has been taken");
//        } else {
//            repository.save(student);
//            return new ResponseResult(200, "Successfully");
//        }
//    }
//
//    public ResponseResult deleteStudent(Long id) {
//        Optional<Student> student = repository.findById(id);
//        if (student.isPresent()) {
//            repository.deleteById(id);
//            return new ResponseResult(200, "Successfully");
//        } else {
//            return new ResponseResult(200, "This id is not exist");
//        }
//    }
//
//    @Transactional
//    public ResponseResult updateStudent(Long id, Student student) {
//        Student checkExistence = repository.findById(id).orElseThrow(() -> new IllegalStateException("does not exist"));
//        checkExistence.setName(student.getName());
//        checkExistence.setAge(student.getAge());
//        checkExistence.setEmail(student.getEmail());
//        checkExistence.setDob(student.getDob());
//        return new ResponseResult(200, "Successfully");
//    }

}

