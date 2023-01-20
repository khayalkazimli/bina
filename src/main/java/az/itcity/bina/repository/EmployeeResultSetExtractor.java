package az.itcity.bina.repository;

import az.itcity.bina.domain.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeResultSetExtractor implements ResultSetExtractor<List<Employee>> {

    @Override
    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Employee> employees = new ArrayList<>();

        while (rs.next()){
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setName(rs.getString("name"));
            employee.setSurname(rs.getString("surname"));
            employee.setSalary(rs.getBigDecimal("salary"));
            employees.add(employee);
        }
        return employees;
    }
}
