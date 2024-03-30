package management.system.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.air.company.AirCompanyRequestDto;
import management.system.app.dto.air.company.AirCompanyResponseDto;
import management.system.app.service.AirCompanyService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Air companies management", description = "Endpoints for managing air companies")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/air-companies")
public class AirCompanyController {
    private final AirCompanyService airCompanyService;

    @GetMapping("/{id}")
    @Operation(summary = "Get air company by id",
            description = "Show information about specific air company")
    public AirCompanyResponseDto findById(@PathVariable Long id) {
        return airCompanyService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Get all air companies",
            description = "Show information about all air companies")
    public List<AirCompanyResponseDto> findAll(Pageable pageable) {
        return airCompanyService.findAll(pageable);
    }

    @PostMapping
    @Operation(summary = "Add air company", description = "Save new air company")
    @ResponseStatus(HttpStatus.CREATED)
    public AirCompanyResponseDto add(@RequestBody @Valid AirCompanyRequestDto requestDto) {
        return airCompanyService.add(requestDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update air company by id",
            description = "Update information about specific air company")
    public AirCompanyResponseDto update(@PathVariable Long id,
            @RequestBody @Valid AirCompanyRequestDto requestDto
    ) {
        return airCompanyService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove air company", description = "Remove specific air company")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        airCompanyService.deleteById(id);
    }
}
