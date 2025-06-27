package com.parekh.ideas.employee_sys.service;
import java.util.List;
import java.util.Optional;

import com.parekh.ideas.employee_sys.entity.Employee;
import com.parekh.ideas.employee_sys.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);

    }
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();

    }

    public Optional<Employee> getspecificEmployeeById(Long id){

        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Long id){
        if(!employeeRepository.existsById(id)){
           throw new EntityNotFoundException("Employee with ID: "+id+" NOT FOUND");
        }
         employeeRepository.deleteById(id);
    }
}
