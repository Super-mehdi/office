package com.mehdi.office;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated; // Needed for enums
import jakarta.persistence.EnumType;

@Entity
class Employee{
        private @Id @GeneratedValue(strategy = GenerationType.AUTO) Integer id;
        private String name;
        private @Enumerated(EnumType.STRING) Dept department;

        public Employee(){}

        public Employee(Integer id, String name, Dept department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Dept getDepartment() {
        return department;
    }
}

