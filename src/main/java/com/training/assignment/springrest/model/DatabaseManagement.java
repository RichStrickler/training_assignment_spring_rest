package com.training.assignment.springrest.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class DatabaseManagement {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void setEmployee(Employee employee) {

    jdbcTemplate.update(
        "INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,DEPT_ID,STAT_CD) VALUES (?,?,?,?,?)",
        new PreparedStatementSetter() {
          public void setValues(PreparedStatement preparedStatement) throws SQLException {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setInt(4, employee.getDeptId());
            preparedStatement.setInt(5, employee.getStatCd());
          }
        });
  }

  public void updateEmployee(Employee employee, int id) {

    jdbcTemplate.update(
        "UPDATE EMPLOYEE SET ID=?, FIRST_NAME=?, LAST_NAME=?, DEPT_ID=?, STAT_CD=? WHERE ID=?",
        new PreparedStatementSetter() {
          public void setValues(PreparedStatement preparedStatement) throws SQLException {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setInt(4, employee.getDeptId());
            preparedStatement.setInt(5, employee.getStatCd());
            preparedStatement.setInt(6, id);
          }
        });
  }


  public void deleteEmployee(int id) {

    jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE ID=?", new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
      }
    });
  }


  public Employee getEmployee(int id) {
    Employee dataSet = new Employee();

    jdbcTemplate.query("SELECT * FROM EMPLOYEE WHERE ID=?", new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
      }
    }, new ResultSetExtractor<Employee>() {
      public Employee extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        if (resultSet.next()) {
          dataSet.setId(resultSet.getInt(1));
          dataSet.setFirstName(resultSet.getString(2));
          dataSet.setLastName(resultSet.getString(3));
          dataSet.setDeptId(resultSet.getInt(4));
          dataSet.setStatCd(resultSet.getInt(5));
        }
        return dataSet;
      }
    });
    return dataSet;
  }


}
