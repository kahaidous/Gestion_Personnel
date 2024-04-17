package ma.emsi.gestion_personnel.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "namephone", types = {Employee.class})
public interface NameAndPhone {
    String getName();
    String getPhone();
}
