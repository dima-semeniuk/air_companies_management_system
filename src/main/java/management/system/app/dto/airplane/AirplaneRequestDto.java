package management.system.app.dto.airplane;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.Data;
import management.system.app.model.Airplane;

@Data
public class AirplaneRequestDto {
    private static final String NOT_NULL = "can't be null";
    @NotNull(message = NOT_NULL)
    private String name;
    @NotNull(message = NOT_NULL)
    private String factorySerialNumber;
    private Long airCompanyId;
    @NotNull(message = NOT_NULL)
    private Integer numberOfFlights;
    @NotNull(message = NOT_NULL)
    private Double flightDistance;
    @NotNull(message = NOT_NULL)
    private Double fuelCapacity;
    @NotNull(message = NOT_NULL)
    private Airplane.Type airplaneType;
    @NotNull(message = NOT_NULL)
    private LocalDate createdAt;
}
