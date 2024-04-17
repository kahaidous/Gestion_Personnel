package ma.emsi.gestion_personnel.services;

import ma.emsi.gestion_personnel.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    Employee addEmployee(Employee e);
    Employee editEmployee(Integer id, Employee e);
    void deleteEmployee(Integer id);
    Employee researchByCIN(String cin);
    Employee researchById(Integer id);
    List<Employee> returnAllEmployees();
}
