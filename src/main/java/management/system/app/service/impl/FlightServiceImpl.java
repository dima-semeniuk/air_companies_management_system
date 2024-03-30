package management.system.app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.dto.flight.FlightResponseDto;
import management.system.app.dto.flight.FlightStatusRequestDto;
import management.system.app.mapper.FlightMapper;
import management.system.app.model.AirCompany;
import management.system.app.model.Airplane;
import management.system.app.model.Flight;
import management.system.app.repository.AirCompanyRepository;
import management.system.app.repository.AirplaneRepository;
import management.system.app.repository.FlightRepository;
import management.system.app.service.FlightService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private static final String CAN_NOT_FIND_FLIGHT_BY_ID_MESSAGE = "Can't find flight by id: ";
    private static final String CAN_NOT_FIND_AIRPLANE_BY_ID_MESSAGE = "Can't find airplane by id: ";
    private static final String CAN_NOT_FIND_COMPANY_BY_ID_MESSAGE = "Can't find company by id: ";
    private static final long TIME_LIMIT = 24;
    private final FlightRepository flightRepository;
    private final AirplaneRepository airplaneRepository;
    private final AirCompanyRepository airCompanyRepository;
    private final FlightMapper flightMapper;

    @Override
    @Transactional
    public FlightResponseDto add(FlightRequestDto requestDto) {
        Airplane airplane = airplaneRepository.findById(requestDto.getAirplaneId()).orElseThrow(
                () -> new EntityNotFoundException(CAN_NOT_FIND_AIRPLANE_BY_ID_MESSAGE
                        + requestDto.getAirplaneId())
        );

        AirCompany airCompany = airCompanyRepository.findById(
                requestDto.getAirCompanyId()).orElseThrow(
                    () -> new EntityNotFoundException(CAN_NOT_FIND_COMPANY_BY_ID_MESSAGE
                        + requestDto.getAirCompanyId())
        );

        Flight flight = flightMapper.toModel(requestDto);
        flight.setAirCompany(airCompany);
        flight.setAirplane(airplane);
        flight.setFlightStatus(Flight.Status.PENDING);
        flight.setCreatedAt(LocalDateTime.now());
        return flightMapper.toDto(flightRepository.save(flight));
    }

    @Override
    public List<FlightResponseDto> findAllActiveFlightsOverLimit(Pageable pageable) {
        LocalDateTime timePoint = LocalDateTime.now().minusHours(TIME_LIMIT);
        return flightRepository
                .findAllActiveFlightsOverLimit(timePoint, pageable).stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightResponseDto> findAllCompletedFlightsOverdue(Pageable pageable) {
        return flightRepository.findAllCompletedFlightsOverdue(pageable).stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<FlightResponseDto> findAllFlightsByCompanyNameAndStatus(
            String name, Flight.Status flightStatus, Pageable pageable) {
        return flightRepository.findAllByAirCompanyNameContainingIgnoreCaseAndFlightStatus(
                name, flightStatus, pageable
                ).stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FlightResponseDto updateStatus(Long id, FlightStatusRequestDto requestDto) {
        Flight flight = flightRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(CAN_NOT_FIND_FLIGHT_BY_ID_MESSAGE + id)
        );

        flight.setFlightStatus(requestDto.getFlightStatus());
        LocalDateTime currentTime = LocalDateTime.now();

        switch (requestDto.getFlightStatus()) {
            case ACTIVE:
                flight.setStartedAt(currentTime);
                break;
            case DELAYED:
                flight.setDelayStartedAt(currentTime);
                break;
            case COMPLETED:
                flight.setEndedAt(currentTime);
                break;
            default: break;
        }

        return flightMapper.toDto(flightRepository.save(flight));
    }
}
