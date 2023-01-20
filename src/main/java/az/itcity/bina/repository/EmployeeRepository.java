package az.itcity.bina.repository;

import az.itcity.bina.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> getEmployeeList();
    Optional<Employee> getEmployeeById(long id);
    Employee add(Employee employee);
    Employee update(Employee employee);
    boolean delete(long id);

}
