package com.mehdi.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    private final Office office;
    public OfficeController(Office office) {
        this.office = office;
    }
    @RequestMapping("/{id}")
    ResponseEntity<Employee> findById(@PathVariable int id){
        Optional<Employee> employeeOptional=office.findById(id);
        if (employeeOptional.isPresent()){
            return ResponseEntity.ok(employeeOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
