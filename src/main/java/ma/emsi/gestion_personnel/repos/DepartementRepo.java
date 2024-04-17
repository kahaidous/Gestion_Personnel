package ma.emsi.gestion_personnel.repos;

import ma.emsi.gestion_personnel.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepo extends JpaRepository<Departement,Long> {
}
