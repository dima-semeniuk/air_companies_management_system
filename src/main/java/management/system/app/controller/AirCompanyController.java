package management.system.app.controller;

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

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/companies")
public class AirCompanyController {
    private final AirCompanyService airCompanyService;

    @GetMapping("/{id}")
    public AirCompanyResponseDto findById(@PathVariable Long id) {
        return airCompanyService.findById(id);
    }

    @GetMapping
    public List<AirCompanyResponseDto> findAll(Pageable pageable) {
        return airCompanyService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirCompanyResponseDto add(@RequestBody @Valid AirCompanyRequestDto requestDto) {
        return airCompanyService.add(requestDto);
    }

    @PutMapping("/{id}")
    public AirCompanyResponseDto update(@PathVariable Long id,
            @RequestBody @Valid AirCompanyRequestDto requestDto
    ) {
        return airCompanyService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        airCompanyService.deleteById(id);
    }

}
