package com.mindtree.employeemanagerapp.service.serviceimpl;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    ArrayList<Employee> employees = new ArrayList<>();

    @BeforeEach
    void createDatabase() {
        Employee employee = new Employee("Sai ","Rohith","sai@gmail.com");
        employees.add(employee);
        System.out.println(employee.getId());
    };


    @Test
    void getAllEmployees() {
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> array = employeeService.getAllEmployees();
        assertEquals(employees,array);


    }

    @Test
    void createEmployee() {
        Employee employee = new Employee("Sai ","RohithReddy","sai1@gmail.com");
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Employee employee1 = employeeService.createEmployee(employee);
        assertEquals(employee1,employee);

    }

    @Test
    void getEmployeeById() {
        Employee employee = new Employee("Sai ","Rohith","sai@gmail.com");
        Mockito.when(employeeRepository.findById(0L)).thenReturn(Optional.of(employee));
        Employee employee1 = employeeService.getEmployeeById(0L);
        assertEquals(employee1,employee);
    }

    @Test
    void updateEmployeeByIdWithNewEmployee() {
        Employee employee = new Employee("Sai ","Rohith","sai@gmail.com");
        Employee employee1 = new Employee("Sai ","RohithReddy","sai1@gmail.com");
        Mockito.when(employeeRepository.findById(0L)).thenReturn(Optional.of(employee));
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Employee updatedEmployee = employeeService.updateEmployeeByIdWithNewEmployee(0L,employee1);
        Employee employeeDetails = employeeService.getEmployeeById(0L);
        assertEquals(updatedEmployee,employeeDetails);
    }

    @Test
    void deleteEmployee() {
    }
}