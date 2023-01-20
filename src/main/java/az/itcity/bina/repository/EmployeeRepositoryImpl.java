package az.itcity.bina.repository;

import az.itcity.bina.domain.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// for using EmployeeRepositoryImplAdvanced
//@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private JdbcTemplate jdbcTemplate;
    private EmployeeRowMapper employeeRowMapper;
    private EmployeeResultSetExtractor employeeResultSetExtractor;

    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate, EmployeeRowMapper employeeRowMapper, EmployeeResultSetExtractor employeeResultSetExtractor) {
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
                "where id = ?";

//        Employee employee = jdbcTemplate.queryForObject(sql, employeeRowMapper, id);
//       if(employee != null){
//           optionalEmployee = Optional.of(employee);
//       }
        // or

        List<Employee> employee = jdbcTemplate.query(sql, employeeRowMapper, id);
        if(!employee.isEmpty()){
            optionalEmployee = Optional.of(employee.get(0));
        }

        return optionalEmployee;
    }

    @Override
    public Employee add(Employee employee) {
        String sql = "insert into employee(name, surname, salary) " +
                "values(?, ?, ?)";
        Object[] data = new Object[]{employee.getName(), employee.getSurname(), employee.getSalary()};
        // without PreparedStatement:
        // int count = jdbcTemplate.update(sql, data);
        // or with PreparedStatement:
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int count = jdbcTemplate.update(new PreparedStatementCreator() {

            // postgres ucun asagidaki gosterilen primary key olan sutunun adini vermek mutleqdir
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getSurname());
                ps.setBigDecimal(3, employee.getSalary());
                return ps;
            }
        }, keyHolder);
        // or with lambda expression
//        int count = jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, employee.getName());
//            ps.setString(2, employee.getSurname());
//            ps.setBigDecimal(3, employee.getSalary());
//            return ps;
//        }, keyHolder);

        if(count == 1){
            System.out.println("isci elave olundu");
            employee.setId(keyHolder.getKey().longValue());
        }
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        String sql = "update employee " +
                "set name = ?, surname = ?, salary = ?" +
                "where id = ?";
        Object[] data = new Object[]{employee.getName(), employee.getSurname(), employee.getSalary(), employee.getId()};
        int count = jdbcTemplate.update(sql, data);

        if(count == 1){
            System.out.println("isci update olundu");
        }
        return employee;
    }

    @Override
    public boolean delete(long id) {
        String sql = "delete from employee " +
                "where id = ?";
        int count = jdbcTemplate.update(sql, id);
        return count > 0;
    }
}
