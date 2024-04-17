package ma.emsi.gestion_personnel.repos;

import ma.emsi.gestion_personnel.entities.Employee;
import ma.emsi.gestion_personnel.entities.EmployeePrj;
import ma.emsi.gestion_personnel.entities.NameAndPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    Employee findByCin(String cin); //findByX : X représente l'attribut dans Employee

    Employee findByNameOrCin(String name, String cin);
    //@Query("JPQL")
    //Employee requeteComplexe();


    //La suppression
    void deleteByCin(String cin);

    EmployeePrj findByCinAndName(String cin, String name);
}
