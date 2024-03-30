package management.system.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.dto.flight.FlightResponseDto;
import management.system.app.dto.flight.FlightStatusRequestDto;
import management.system.app.model.Flight;
import management.system.app.service.FlightService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Flights management", description = "Endpoints for managing flights")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/flights")
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/by-company-name-and-status")
    @Operation(summary = "Get all flights by air company name and flight status",
            description = "Show information about all flights by air company name "
                    + "and flight status")
    public List<FlightResponseDto> findAllByCompanyNameAndStatus(
            @RequestParam(name = "air-company-name") String name,
            @RequestParam(name = "status") Flight.Status flightStatus,
            Pageable pageable) {
        return flightService.findAllFlightsByCompanyNameAndStatus(name, flightStatus,
                pageable);
    }

    @GetMapping("/active-over-limit")
    @Operation(summary = "Get all active lights, that are longer than 24 hours",
            description = "Show information about all active flights, starts more "
                    + "than 24 hours ago")
    public List<FlightResponseDto> findAllActiveOverLimit(Pageable pageable) {
        return flightService.findAllActiveFlightsOverLimit(pageable);
    }

    @GetMapping("/completed-overdue")
    @Operation(summary = "Get all completed lights and longer than the estimated flight time",
            description = "Show information about all completed flights, that were longer "
                    + "than the estimated flight time")
    public List<FlightResponseDto> findAllCompletedOverdue(Pageable pageable) {
        return flightService.findAllCompletedFlightsOverdue(pageable);
    }

    @PostMapping
    @Operation(summary = "Add flight", description = "Add new flights")
    @ResponseStatus(HttpStatus.CREATED)
    public FlightResponseDto add(@RequestBody @Valid FlightRequestDto requestDto) {
        return flightService.add(requestDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update flight status for the flight by id",
            description = "Change flight status for the specific flight")
    public FlightResponseDto updateStatus(@PathVariable Long id,
            @RequestBody @Valid FlightStatusRequestDto requestDto) {
        return flightService.updateStatus(id, requestDto);
    }
}
