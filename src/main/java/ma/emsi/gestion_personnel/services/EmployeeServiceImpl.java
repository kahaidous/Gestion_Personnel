package ma.emsi.gestion_personnel.services;

import ma.emsi.gestion_personnel.entities.Employee;
import ma.emsi.gestion_personnel.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public Employee addEmployee(Employee e) {
        return employeeRepo.save(e);
    }

    @Override
    public Employee editEmployee(Integer id, Employee e) {
        Employee empToBeEdited = employeeRepo.findById(id).get();
        if(empToBeEdited !=null){
            empToBeEdited.setName(e.getName());
            //Same thing for other attribues
            employeeRepo.save(empToBeEdited);
            return empToBeEdited;
        }
        return null;
    }

    @Override
    public void deleteEmployee(Integer id) {
            employeeRepo.deleteById(id);
    }

    @Override
    public Employee researchByCIN(String cin) {
        return employeeRepo.findByCin(cin);
    }

    @Override
    public Employee researchById(Integer id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public List<Employee> returnAllEmployees() {
        return employeeRepo.findAll();
    }
}
