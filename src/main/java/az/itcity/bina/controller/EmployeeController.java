package az.itcity.bina.controller;

import az.itcity.bina.domain.Employee;
import az.itcity.bina.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

//    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping()
    public ModelAndView viewEmployees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/employees");
        modelAndView.addObject("employees", employeeRepository.getEmployeeList());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView viewEmployeeById(@PathVariable(name = "id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/employee-detail");
        Optional<Employee> optionalEmployee =  employeeRepository.getEmployeeById(id);

        if(optionalEmployee.isPresent()){
            modelAndView.addObject("employee",optionalEmployee.get());
        }
        // or
        // optionalEmployee.ifPresent(employee -> modelAndView.addObject("employee", employee));
        return modelAndView;
    }

    @GetMapping("/add")
    public String addEmployee(){
        return "employee/add";
    }

    @PostMapping("/add")
    public String addEmployee(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "salary") BigDecimal salary
    ) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setSalary(salary);

       employee = employeeRepository.add(employee);
        System.out.println("yeni isci elave olundu = " + employee);
        return "redirect:/employees/";
    }

    @GetMapping("/{id}/update")
    public ModelAndView viewEmployeeForUpdate(@PathVariable(name = "id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/update");
        Optional<Employee> optionalEmployee =  employeeRepository.getEmployeeById(id);
        optionalEmployee.ifPresent(employee -> modelAndView.addObject("employee", employee));
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateEmployee(
            @RequestParam(name = "id") long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "salary") BigDecimal salary
    ) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setSurname(surname);
        employee.setSalary(salary);

        employee = employeeRepository.update(employee);
        System.out.println("isci update olundu = " + employee);
        return "redirect:/employees/";
    }

    @GetMapping("{id}/delete")
    public String deleteEmployee(@PathVariable(name = "id") long id){
        employeeRepository.delete(id);
        return "redirect:/employees/";
    }

    @GetMapping(value = {"/json", "/test"})
    @ResponseBody
    public List<Employee> viewEmployeesJson() {
        return employeeRepository.getEmployeeList();
    }

    @GetMapping("/json2")
    public ResponseEntity<List<Employee>> viewEmployeesJsonEntity() {
        return ResponseEntity.ok()
                .header("itcity","academy")
                .body(employeeRepository.getEmployeeList());
    }
}
