package management.system.app.service;

import java.util.List;
import management.system.app.dto.air.company.AirCompanyRequestDto;
import management.system.app.dto.air.company.AirCompanyResponseDto;
import org.springframework.data.domain.Pageable;

public interface AirCompanyService {
    List<AirCompanyResponseDto> findAll(Pageable pageable);

    AirCompanyResponseDto findById(Long id);

    AirCompanyResponseDto add(AirCompanyRequestDto requestDto);

    AirCompanyResponseDto update(Long id, AirCompanyRequestDto requestDto);

    void deleteById(Long id);
}
