package ma.emsi.gestion_personnel.repos;

import ma.emsi.gestion_personnel.entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepo extends JpaRepository<Salary, Long> {
}
