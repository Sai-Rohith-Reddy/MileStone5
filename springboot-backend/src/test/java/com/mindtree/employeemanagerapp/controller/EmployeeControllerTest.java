package com.mindtree.employeemanagerapp.controller;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @MockBean
    EmployeeService employeeService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void createDatabase() {
        Employee employee = new Employee("Sai ","Rohith","sai@gmail.com");

    }

    @Test
    void getAllEmployees() throws Exception {
        Employee employee = new Employee("Sai ","Rohith","sai@gmail.com");
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee);
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeArrayList);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstname").value("Sai"));
    }

    @Test
    void createEmployee() throws Exception {
        Employee employee = new Employee("Sai ","Rohith","sai@gmail.com");
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee);
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeArrayList);
        mockMvc.perform(MockMvcRequestBuilders.post("/employees"))
                .andExpect(status().isOk());


    }

    @Test
    void getEmployeeById() throws Exception {
        Employee employee = new Employee("Sai ","Rohith","sai@gmail.com");
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee);
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeArrayList);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/{id}"))
                .andExpect(status().isOk());

    }

    @Test
    void updateEmployee() throws Exception {
        Employee employee = new Employee("Sai ","Rohith","sai@gmail.com");
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee);
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeArrayList);
        mockMvc.perform(MockMvcRequestBuilders.put("/employees/{id}"))
                .andExpect(status().isOk());

    }


    @Test
    void deleteEmployee() throws Exception {
        Employee employee = new Employee("Sai ","Rohith","sai@gmail.com");
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee);
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeArrayList);
        mockMvc.perform(MockMvcRequestBuilders.delete("/employee/{id}"))
                .andExpect(status().isOk());

    }
}