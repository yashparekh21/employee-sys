package com.parekh.ideas.employee_sys.repository;

import com.parekh.ideas.employee_sys.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
