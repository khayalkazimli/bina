package az.itcity.bina.repository;

import az.itcity.bina.domain.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImplAdvanced implements EmployeeRepository{

    private NamedParameterJdbcTemplate jdbcTemplate;
    private EmployeeRowMapper employeeRowMapper;
    private EmployeeResultSetExtractor employeeResultSetExtractor;

    public EmployeeRepositoryImplAdvanced(NamedParameterJdbcTemplate jdbcTemplate, EmployeeRowMapper employeeRowMapper, EmployeeResultSetExtractor employeeResultSetExtractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeRowMapper = employeeRowMapper;
        this.employeeResultSetExtractor = employeeResultSetExtractor;
    }


    @Override
    public List<Employee> getEmployeeList() {
        String sql = "select id, name, surname, salary " +
                "from employee " +
                "order by id";

        return jdbcTemplate.query(sql, employeeRowMapper);
        // or
//        List<Employee> employees = jdbcTemplate.query(sql,employeeRowMapper);
//        return employees;

        // by using  ResultSetExtractor class without RowMapper. ResultSetExtractor birdefeye hamisini cigarir.
        // return jdbcTemplate.query(sql, employeeResultSetExtractor);



    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        Optional<Employee> optionalEmployee = Optional.empty();
        String sql = "select id, name, surname, salary " +
                "from employee " +
                "where id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        List<Employee> employee = jdbcTemplate.query(sql, params, employeeRowMapper);
        if(!employee.isEmpty()){
            optionalEmployee = Optional.of(employee.get(0));
        }

        return optionalEmployee;
    }

    @Override
    public Employee add(Employee employee) {
        String sql = "insert into employee(name, surname, salary) " +
                "values(:name, :surname, :salary)";
        MapSqlParameterSource params = new MapSqlParameterSource("name", employee.getName())
                .addValue("surname", employee.getSurname())
                .addValue("salary",  employee.getSalary());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int count = jdbcTemplate.update(sql, params,keyHolder,new String[]{"id"});

        if(count == 1){
            System.out.println("isci elave olundu");
            employee.setId(keyHolder.getKey().longValue());
        }
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        String sql = "update employee " +
                "set name = :name, surname = :surname, salary = :salary " +
                "where id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("name", employee.getName())
                .addValue("surname", employee.getSurname())
                .addValue("salary",  employee.getSalary())
                .addValue("id", employee.getId());
        int count = jdbcTemplate.update(sql, params);

        if(count == 1){
            System.out.println("isci update olundu");
        }
        return employee;
    }

    @Override
    public boolean delete(long id) {
        String sql = "delete from employee " +
                "where id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        int count = jdbcTemplate.update(sql, params);
        return count > 0;
    }
}
