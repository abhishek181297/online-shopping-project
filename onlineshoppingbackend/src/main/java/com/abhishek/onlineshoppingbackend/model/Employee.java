package com.abhishek.onlineshoppingbackend.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String dept;
    private double salary;
}
