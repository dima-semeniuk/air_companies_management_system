package management.system.app.dto.flight;

import java.time.LocalDateTime;
import lombok.Data;
import management.system.app.dto.air.company.AirCompanyResponseDto;
import management.system.app.dto.airplane.AirplaneResponseDto;
import management.system.app.model.Flight;

@Data
public class FlightResponseDto {
    private Long id;
    private Flight.Status flightStatus;
    private AirCompanyResponseDto airCompany;
    private AirplaneResponseDto airplane;
    private String departureCountry;
    private String destinationCountry;
    private Integer distance;
    private String estimatedFlightTime;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;
}
