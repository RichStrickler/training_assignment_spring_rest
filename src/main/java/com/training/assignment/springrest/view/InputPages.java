package com.training.assignment.springrest.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.assignment.springrest.model.DatabaseManagement;
import com.training.assignment.springrest.model.Employee;

@RestController
public class InputPages {
  @Autowired
  DatabaseManagement db;

  @GetMapping("/employee")
  @ResponseBody
  public Employee getEmployee(@RequestParam int id) {
    Employee empData = new Employee();

    empData = db.getEmployee(id);

    return empData;
  }

  @GetMapping("/test")
  @ResponseBody
  public String getEmployee() {

    return "Hello";
  }

  @GetMapping("/employee/{id}")
  @ResponseBody
  public Employee getEmployeePath(@PathVariable("id") int id) {
    Employee empData = new Employee();

    empData = db.getEmployee(id);

    return empData;
  }

}
