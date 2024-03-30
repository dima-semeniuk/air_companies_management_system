package management.system.app.service;

import java.util.List;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.dto.airplane.AirplaneResponseDto;
import management.system.app.dto.airplane.ChangeCompanyRequestDto;
import org.springframework.data.domain.Pageable;

public interface AirplaneService {
    AirplaneResponseDto updateAirCompany(Long id, ChangeCompanyRequestDto requestDto);

    AirplaneResponseDto add(AirplaneRequestDto requestDto);

    List<AirplaneResponseDto> findAll(Pageable pageable);
}
