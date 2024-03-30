package management.system.app.controller;

import javax.validation.Valid;
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

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;

    @PatchMapping("/{id}")
    public AirplaneResponseDto updateAirCompany(
            @PathVariable Long id,
            @RequestBody @Valid ChangeCompanyRequestDto requestDto
    ) {
        return airplaneService.updateAirCompany(id, requestDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirplaneResponseDto add(@RequestBody @Valid AirplaneRequestDto requestDto) {
        return airplaneService.add(requestDto);
    }
}
