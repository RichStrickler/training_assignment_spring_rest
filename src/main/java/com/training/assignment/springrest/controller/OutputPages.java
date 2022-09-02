package com.training.assignment.springrest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.training.assignment.springrest.model.DatabaseManagement;
import com.training.assignment.springrest.model.Employee;

public class OutputPages {

  DatabaseManagement db =
      new DatabaseManagement("jdbc:mysql://localhost:3306/JDBCDemo", "root", "S2xj8!efD4m37");

  @PostMapping("/Employee")
  @ResponseBody
  public void postEmployee(@RequestBody Employee teleData) {
    Employee empData = teleData;

    db.initializeDatabase();
    db.setEmployee(empData);

  }

  @PutMapping("/Employee/{id}")
  @ResponseBody
  public void putEmployee(@RequestBody Employee teleData, @PathVariable("id") int id) {

    db.initializeDatabase();
    db.updateEmployee(teleData, id);

  }

  @DeleteMapping("/Employee/{id}")
  @ResponseBody
  public void deleteEmployee(@PathVariable("id") int id) {
    db.initializeDatabase();
    db.deleteEmployee(id);

  }



}
