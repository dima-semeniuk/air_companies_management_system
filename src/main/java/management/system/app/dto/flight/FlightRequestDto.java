package management.system.app.dto.flight;

import javax.validation.constraints.NotNull;
import lombok.Data;
import management.system.app.validation.CorrectFormat;

@Data
public class FlightRequestDto {
    private static final String NOT_NULL = "can't be null";
    @NotNull(message = NOT_NULL)
    private Long airCompanyId;
    @NotNull(message = NOT_NULL)
    private Long airplaneId;
    @NotNull(message = NOT_NULL)
    private String departureCountry;
    @NotNull(message = NOT_NULL)
    private String destinationCountry;
    @NotNull(message = NOT_NULL)
    private Integer distance;
    @NotNull(message = NOT_NULL)
    @CorrectFormat
    private String estimatedFlightTime;
}
