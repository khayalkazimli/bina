package az.itcity.bina.repository;

import az.itcity.bina.domain.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int i) throws SQLException {
//        String sql = "select id, name, surname, salary " +
//                "from employees " +
//                "order by id";
        System.out.println("setir " + i + " isci obyektine cevir");
        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setName(rs.getString("name"));
        employee.setSurname(rs.getString("surname"));
        employee.setSalary(rs.getBigDecimal("salary"));

        return employee;
    }
}
