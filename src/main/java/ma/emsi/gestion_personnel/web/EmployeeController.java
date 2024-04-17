package ma.emsi.gestion_personnel.web;

import ma.emsi.gestion_personnel.entities.Employee;
import ma.emsi.gestion_personnel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/all")
    List<Employee> allEmployees(){
        return employeeService.returnAllEmployees();
    }
    @GetMapping("/cin/{cin}")
    Employee empByCin(@PathVariable String cin){
        return employeeService.researchByCIN(cin);
    }

    @GetMapping("/{id}")
    Employee empByID(@PathVariable Integer id){
        return employeeService.researchById(id);
    }

    @GetMapping("/cin")
    Employee empByCin1(@RequestParam String cin){
        return employeeService.researchByCIN(cin);
    }
    @PostMapping("/add")
    Employee insertEmployee(@RequestBody Employee e){
        return employeeService.addEmployee(e);
    }
    @PutMapping("/edit/{id}")
    Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee e){
        return employeeService.editEmployee(id,e);
    }
    @DeleteMapping("/delete/{id}")
    void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }
}
