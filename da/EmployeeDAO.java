package com.mikadosolutions.training.spring.da;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public int getTotalEmployees() {
		int totalEmployees = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employee", Integer.class);
		return totalEmployees;
	}

	public int countOfEmployeesByName(String name) {
		int totalEmployees = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employee WHERE name = ?", new Object[] { name }, Integer.class);
		return totalEmployees;
	}

	public int countOfEmployeesByFirstName(String name) {
		String sql = "SELECT COUNT(*) FROM employee WHERE name = :name";
		SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}

	/*public int countOfEmployeesByFirstName(String name) {
		String sql = "SELECT COUNT(*) FROM employee WHERE name = :name";
		Map namedParameters = new Hashtable();
		namedParameters.put("name", name);
		return namedParameterJdbcTemplate.queryForInt(sql, namedParameters);
	}*/

	/*public int countOfEmployeesByFirstName(String name) {
		String sql = "SELECT COUNT(*) FROM employee WHERE name = :name";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(new Employee(0, "Sunil", 0));
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}*/

	public String getNameForId(int id) {
		String name = (String) jdbcTemplate.queryForObject("SELECT name FROM employee WHERE id = ?", new Object[] { id }, String.class);
		return name;
	}

	public Employee getEmployee(final int id) {
		Employee employee = (Employee) jdbcTemplate.queryForObject("SELECT name, salary FROM employee WHERE id = ?", new Object[] { id }, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) {
				Employee employee = new Employee();
				try {
					System.out.println("Row number = " + rowNum);
					employee.setId(id);
					employee.setName(rs.getString("name"));
					employee.setSalary(rs.getDouble("salary"));
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return employee;
			}
		});

		return employee;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = jdbcTemplate.query("SELECT * FROM employee", new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) {
				System.out.println("Row number = " + rowNum);
				Employee employee = new Employee();
				try {
					employee.setId(rs.getInt(1));
					employee.setName(rs.getString(2));
					employee.setSalary(rs.getDouble(3));
				} catch (SQLException e) {
					System.out.println(e);
				}

				return employee;
			}
		});
		
		return employees;
	}

	/*public void addEmployee(Employee employee) {
		int i = jdbcTemplate.update("INSERT INTO employee VALUES (?, ?, ?)", new Object[] { employee.getId(), employee.getName(), employee.getSalary() });
	}*/

	public void editEmployee(Employee employee) {
		int i = jdbcTemplate.update("UPDATE employee SET salary = ? WHERE id = ?", new Object[] { employee.getSalary(), employee.getId() });
	}

	public void deleteEmployee(Employee employee) {
		int i = jdbcTemplate.update("DELETE FROM employee WHERE id = ?", new Object[] { employee.getId() });
	}

	public void createTable() {
		jdbcTemplate.execute("CREATE TABLE stable (id INT(10) PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50))");
	}

	public void addEmployee(Employee employee) {
		namedParameterJdbcTemplate.update("INSERT INTO employee VALUES (:id, :name, :salary)", new BeanPropertySqlParameterSource(employee));
	}
}