package management.system.app.dto.air.company;

import lombok.Data;
import management.system.app.model.AirCompany;

@Data
public class AirCompanyResponseDto {
    private Long id;
    private String name;
    private AirCompany.Type companyType;
    private Integer foundedAt;
}
