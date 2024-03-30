package management.system.app.controller;

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

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/flights")
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/by-company-name-and-status")
    public List<FlightResponseDto> findAllByCompanyNameAndStatus(
            @RequestParam(name = "air-company-name") String name,
            @RequestParam(name = "status") Flight.Status flightStatus,
            Pageable pageable) {
        return flightService.findAllFlightsByCompanyNameAndStatus(name, flightStatus,
                pageable);
    }

    @GetMapping("/active-over-limit")
    public List<FlightResponseDto> findAllActiveOverLimit(Pageable pageable) {
        return flightService.findAllActiveFlightsOverLimit(pageable);
    }

    @GetMapping("/completed-overdue")
    public List<FlightResponseDto> findAllCompletedOverdue(Pageable pageable) {
        return flightService.findAllCompletedFlightsOverdue(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlightResponseDto add(@RequestBody @Valid FlightRequestDto requestDto) {
        return flightService.add(requestDto);
    }

    @PatchMapping("/{id}")
    public FlightResponseDto updateStatus(@PathVariable Long id,
            @RequestBody @Valid FlightStatusRequestDto requestDto) {
        return flightService.updateStatus(id, requestDto);
    }
}
