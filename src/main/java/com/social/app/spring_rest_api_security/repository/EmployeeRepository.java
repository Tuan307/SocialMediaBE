package com.social.app.spring_rest_api_security.repository;
import com.social.app.spring_rest_api_security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}

