package ma.emsi.gestion_personnel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Departement {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    private Employee chefDepart;
    @OneToMany(mappedBy = "departement")
    private List<Employee> employeeList;
}
