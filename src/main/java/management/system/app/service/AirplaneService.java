package management.system.app.service;

import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.dto.airplane.AirplaneResponseDto;
import management.system.app.dto.airplane.ChangeCompanyRequestDto;

public interface AirplaneService {
    AirplaneResponseDto updateAirCompany(Long id, ChangeCompanyRequestDto requestDto);

    AirplaneResponseDto add(AirplaneRequestDto requestDto);
}
