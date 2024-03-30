package management.system.app.dto.air.company;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import management.system.app.model.AirCompany;

@Data
public class AirCompanyRequestDto {
    @NotNull(message = "can't be null")
    @Size(max = 100, message = "can't be greater than 100 characters")
    private String name;

    @NotNull
    private AirCompany.Type companyType;

    @NotNull(message = "year can't be null")
    private Integer foundedAt;
}
