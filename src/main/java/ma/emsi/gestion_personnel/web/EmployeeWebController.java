package ma.emsi.gestion_personnel.web;

import ma.emsi.gestion_personnel.entities.Employee;
import ma.emsi.gestion_personnel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeWebController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/index")
    String allEmployees(Model model){
        List<Employee> employeeList = employeeService.returnAllEmployees();
        model.addAttribute("employees", employeeList);
        model.addAttribute("title", "Liste de mes employés");
        model.addAttribute("count", employeeList.size());
        return "employees"; //Nom de la vue (Page HTML)
    }

}
