package com.training.assignment.springrest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.assignment.springrest.model.DatabaseManagement;
import com.training.assignment.springrest.model.Employee;

@RestController
public class OutputPages {

  DatabaseManagement db =
      new DatabaseManagement("jdbc:mysql://localhost:3306/JDBCDemo", "root", "S2xj8!efD4m37");

  @PostMapping("/employee")
  @ResponseBody
  public void postEmployee(@RequestBody Employee teleData) {
    Employee empData = teleData;

    db.setEmployee(empData);

  }

  @PutMapping("/employee/{id}")
  @ResponseBody
  public void putEmployee(@RequestBody Employee teleData, @PathVariable("id") int id) {

    db.updateEmployee(teleData, id);

  }

  @DeleteMapping("/employee/{id}")
  @ResponseBody
  public void deleteEmployee(@PathVariable("id") int id) {

    db.deleteEmployee(id);

  }



}
