package management.system.app.dto.flight;

import javax.validation.constraints.NotNull;
import lombok.Data;
import management.system.app.model.Flight;

@Data
public class FlightStatusRequestDto {
    @NotNull
    private Flight.Status flightStatus;
}
