package ma.emsi.gestion_personnel;

import ma.emsi.gestion_personnel.entities.Employee;
import ma.emsi.gestion_personnel.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GestionPersonnelApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepo employeeRepo;
    public static void main(String[] args) {
        SpringApplication.run(GestionPersonnelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //L'insertion des employés ==> CREATE
        for(int i=1; i<=10; i++){
            employeeRepo
                    .save(new Employee(null,"Mohamed_"+i, new Date(),"BA2323"+i,"+212600"+i+"000",new Date()));
        }

        //Lecture ==> READ All records
        List<Employee> listeEmp =  employeeRepo.findAll();
        for (Employee e:listeEmp){
            System.out.println("Nom: " + e.getName() + " - "+ "CIN: "+e.getCin());
        }

        //Lecture ==> READ ONE record
        System.out.println("Employe: 7");
        if(employeeRepo.existsById(70)) //If exist
            System.out.println(employeeRepo.findById(70).get());
        else
            System.out.println("Employee not found!");

        //Recherche par CIN
        System.out.println(employeeRepo.findByCin("BA123239"));

        //Recherche par CIN et Nom
        System.out.println(employeeRepo.findByNameOrCin("Mohamed", "BA1232307"));

        //La suppression du 5em emp
         employeeRepo.deleteById(5);
        if(employeeRepo.existsById(5)) //If exist
            System.out.println(employeeRepo.findById(5).get());
        else
            System.out.println("Employee not found!");

        //Modification du nom
        Employee employee7 = employeeRepo.findById(7).get();
        employee7.setName("Ahmed");
        employeeRepo.save(employee7);
        System.out.println(employeeRepo.findById(7).get());

    }
}
