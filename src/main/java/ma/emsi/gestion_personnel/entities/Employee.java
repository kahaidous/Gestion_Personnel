package ma.emsi.gestion_personnel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

//@Data = @Getter + @Setter +@ToString ...
@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "Personnel")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "Nom")
    private String name;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(unique = false,nullable = false,length = 8)
    @JsonIgnore //Eliminer l'affichage du CIN
    private String cin;
    private String phone;
    @OneToOne
    private Salary salary;
    @ManyToOne
    private Departement departement;
}
