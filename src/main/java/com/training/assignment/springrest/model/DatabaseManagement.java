package com.training.assignment.springrest.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseManagement {

  JdbcTemplate dbManager = null;

  String jdbcUrl = "jdbc:mysql://localhost:3306/JDBCDemo";
  String jdbcUsername = "root";
  String jdbcPassword = "S2xj8!efD4m37";

  public DatabaseManagement(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
    this.jdbcUrl = jdbcUrl;
    this.jdbcUsername = jdbcUsername;
    this.jdbcPassword = jdbcPassword;

    dbManager.setDataSource(dataSource());

  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource source = new DriverManagerDataSource();
    source.setDriverClassName("com.mysql.jdbc.driver");
    source.setUrl(jdbcUrl);
    source.setUsername(jdbcUsername);
    source.setPassword(jdbcPassword);
    return source;
  }

  public void setEmployee(Employee employee) {

    dbManager.update(
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

    dbManager.update(
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

    dbManager.update("DELETE FROM EMPLOYEE WHERE ID=?", new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
      }
    });
  }


  public Employee getEmployee(int id) {
    Employee dataSet = new Employee();

    dbManager.update("SELECT * FROM EMPLOYEE WHERE ID=?", new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
      }
    }, new ResultSetExtractor<String>() {
      public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        if (resultSet.next()) {
          dataSet.setId(resultSet.getInt(1));
          dataSet.setFirstName(resultSet.getString(2));
          dataSet.setLastName(resultSet.getString(3));
          dataSet.setDeptId(resultSet.getInt(4));
          dataSet.setStatCd(resultSet.getInt(5));
        }
        return null;
      }
    });
    return dataSet;
  }


}
