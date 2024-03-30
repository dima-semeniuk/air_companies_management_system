package management.system.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.air.company.AirCompanyRequestDto;
import management.system.app.dto.air.company.AirCompanyResponseDto;
import management.system.app.mapper.AirCompanyMapper;
import management.system.app.model.AirCompany;
import management.system.app.repository.AirCompanyRepository;
import management.system.app.service.AirCompanyService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirCompanyServiceImpl implements AirCompanyService {
    private static final String CAN_NOT_FIND_BY_ID_MESSAGE = "Can't find company by id: ";
    private final AirCompanyRepository airCompanyRepository;
    private final AirCompanyMapper airCompanyMapper;

    @Override
    public List<AirCompanyResponseDto> findAll(Pageable pageable) {
        return airCompanyRepository.findAll(pageable).stream()
                .map(airCompanyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AirCompanyResponseDto findById(Long id) {
        return airCompanyMapper.toDto(airCompanyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(CAN_NOT_FIND_BY_ID_MESSAGE + id)
        ));
    }

    @Override
    public AirCompanyResponseDto add(AirCompanyRequestDto requestDto) {
        return airCompanyMapper.toDto(airCompanyRepository.save(
                airCompanyMapper.toModel(requestDto)));
    }

    @Override
    public AirCompanyResponseDto update(Long id, AirCompanyRequestDto requestDto) {
        airCompanyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(CAN_NOT_FIND_BY_ID_MESSAGE + id)
        );

        AirCompany updatedAirCompany = airCompanyMapper.toModel(requestDto);
        updatedAirCompany.setId(id);
        return airCompanyMapper.toDto(airCompanyRepository.save(updatedAirCompany));
    }

    @Override
    public void deleteById(Long id) {
        airCompanyRepository.deleteById(id);
    }
}
