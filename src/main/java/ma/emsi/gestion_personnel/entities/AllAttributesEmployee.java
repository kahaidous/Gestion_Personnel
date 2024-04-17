package ma.emsi.gestion_personnel.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "all", types = {Employee.class})
public interface AllAttributesEmployee {
    String getName();
    String getPhone();
    String getCin();
    Date getBirthDate();
}
