package ma.emsi.gestion_personnel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Salary {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float amount;
    @OneToOne(mappedBy = "salary")
    private Employee employee;
}
