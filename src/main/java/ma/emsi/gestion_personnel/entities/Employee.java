package ma.emsi.gestion_personnel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@AllArgsConstructor @NoArgsConstructor
//@Data = @Getter + @Setter +@ToString ...
@Data
@Table(name = "Personnel")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "Nom")
    private String name;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(unique = true,nullable = false,length = 8)
    private String cin;
    @Transient
    private String phone;
    @Temporal(TemporalType.TIME)
    private Date h;
}
