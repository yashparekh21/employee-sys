package com.parekh.ideas.employee_sys.controller;

import java.util.List;
import java.util.Optional;

import com.parekh.ideas.employee_sys.entity.Employee;
import com.parekh.ideas.employee_sys.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee){

        return employeeService.postEmployee(employee);

    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getspecificEmployeeById(@PathVariable Long id){
     return employeeService.getspecificEmployeeById(id);

    }

    @DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("Employee with ID "+id+" deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>("Employee Not Found!!! "+id, HttpStatus.NOT_FOUND);
        }
    }

}
