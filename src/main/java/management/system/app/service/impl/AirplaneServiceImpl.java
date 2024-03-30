package management.system.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.dto.airplane.AirplaneResponseDto;
import management.system.app.dto.airplane.ChangeCompanyRequestDto;
import management.system.app.mapper.AirplaneMapper;
import management.system.app.model.AirCompany;
import management.system.app.model.Airplane;
import management.system.app.repository.AirplaneRepository;
import management.system.app.service.AirplaneService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private static final String CAN_NOT_FIND_PLANE_BY_ID_MESSAGE = "Can't find airplane by id: ";
    private final AirplaneRepository airplaneRepository;
    private final AirplaneMapper airplaneMapper;

    @Override
    public AirplaneResponseDto add(AirplaneRequestDto requestDto) {
        Airplane airplane = airplaneMapper.toModel(requestDto);

        if (requestDto.getAirCompanyId() != null) {
            airplane.setAirCompany(new AirCompany(requestDto.getAirCompanyId()));
        }

        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }

    @Override
    public List<AirplaneResponseDto> findAll(Pageable pageable) {
        return airplaneRepository.findAll(pageable).stream()
                .map(airplaneMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AirplaneResponseDto updateAirCompany(Long id, ChangeCompanyRequestDto requestDto) {
        Airplane airplane = airplaneRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(CAN_NOT_FIND_PLANE_BY_ID_MESSAGE + id)
        );
        airplane.setAirCompany(new AirCompany(requestDto.getAirCompanyId()));
        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }
}
