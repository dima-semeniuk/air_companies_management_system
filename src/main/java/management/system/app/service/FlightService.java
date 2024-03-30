package management.system.app.service;

import java.util.List;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.dto.flight.FlightResponseDto;
import management.system.app.dto.flight.FlightStatusRequestDto;
import management.system.app.model.Flight;
import org.springframework.data.domain.Pageable;

public interface FlightService {
    List<FlightResponseDto> findAllActiveFlightsOverLimit(Pageable pageable);

    List<FlightResponseDto> findAllCompletedFlightsOverdue(Pageable pageable);

    List<FlightResponseDto> findAllFlightsByCompanyNameAndStatus(
            String name, Flight.Status flightStatus, Pageable pageable);

    FlightResponseDto add(FlightRequestDto requestDto);

    FlightResponseDto updateStatus(Long id, FlightStatusRequestDto requestDto);
}
