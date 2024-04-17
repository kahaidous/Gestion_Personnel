package ma.emsi.gestion_personnel;

import ma.emsi.gestion_personnel.entities.Departement;
import ma.emsi.gestion_personnel.entities.Employee;
import ma.emsi.gestion_personnel.entities.Salary;
import ma.emsi.gestion_personnel.repos.DepartementRepo;
import ma.emsi.gestion_personnel.repos.EmployeeRepo;
import ma.emsi.gestion_personnel.repos.SalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class GestionPersonnelApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired SalaryRepo salaryRepo;
    @Autowired
    DepartementRepo departementRepo;
    public static void main(String[] args) {
        SpringApplication.run(GestionPersonnelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee =  employeeRepo.findByCin("BA23233");
        Departement dep = departementRepo.save(new Departement(null, "Dep Informatique",
              employee ,null));
        Random rand = new Random();
        Salary salary;
        //L'insertion des employés ==> CREATE
        for(int i=1; i<=10; i++){
            salary = salaryRepo.save(new Salary(null,
                    rand.nextFloat()*1000,null));
            employeeRepo
                    .save(new Employee(null,"Mohamed_"+i, new Date(),
                            "BA2323"+i,"+212600"+i+"000",salary,dep));
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

        System.out.println("TEST Projection");
        System.out.println(employeeRepo.findByCinAndName("BL23236","Yassine"));

    }
}
