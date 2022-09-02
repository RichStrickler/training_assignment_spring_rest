package com.training.assignment.springrest.model;

public class Employee {

  public String firstName;
  public String lastName;
  public int id;
  public int deptId;
  public int statCd;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDeptId() {
    return deptId;
  }

  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  public int getStatCd() {
    return statCd;
  }

  public void setStatCd(int statCd) {
    this.statCd = statCd;
  }



}
