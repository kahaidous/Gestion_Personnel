package ma.emsi.gestion_personnel.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = {Employee.class})
public interface EmployeePrj {
    @Value("#{target.name} #{target.cin}")
    String getNameCin();
}
