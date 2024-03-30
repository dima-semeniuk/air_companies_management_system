package management.system.app.controller;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.dto.airplane.AirplaneResponseDto;
import management.system.app.dto.airplane.ChangeCompanyRequestDto;
import management.system.app.service.AirplaneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Airplanes management", description = "Endpoints for managing airplanes")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;

    @PatchMapping("/{id}")
    @Operation(summary = "Change air company for the plane by id",
            description = "Change air company for the specific airplane")
    public AirplaneResponseDto updateAirCompany(
            @PathVariable Long id,
            @RequestBody @Valid ChangeCompanyRequestDto requestDto
    ) {
        return airplaneService.updateAirCompany(id, requestDto);
    }

    @PostMapping
    @Operation(summary = "Add airplane", description = "Save new airplane")
    @ResponseStatus(HttpStatus.CREATED)
    public AirplaneResponseDto add(@RequestBody @Valid AirplaneRequestDto requestDto) {
        return airplaneService.add(requestDto);
    }
}
