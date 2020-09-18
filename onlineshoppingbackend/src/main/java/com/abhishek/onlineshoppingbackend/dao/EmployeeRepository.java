package com.abhishek.onlineshoppingbackend.dao;

import com.abhishek.onlineshoppingbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDept(String dept);
}
