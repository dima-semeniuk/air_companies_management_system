package management.system.app.dto.airplane;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChangeCompanyRequestDto {
    @NotNull(message = "can't be null")
    private Long airCompanyId;
}
