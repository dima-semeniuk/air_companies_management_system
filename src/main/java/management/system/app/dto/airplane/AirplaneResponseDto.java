package management.system.app.dto.airplane;

import java.time.LocalDate;
import lombok.Data;
import management.system.app.model.Airplane;

@Data
public class AirplaneResponseDto {
    private Long id;
    private String name;
    private String factorySerialNumber;
    private Long airCompanyId;
    private Integer numberOfFlights;
    private Double flightDistance;
    private Double fuelCapacity;
    private Airplane.Type airplaneType;
    private LocalDate createdAt;
}
