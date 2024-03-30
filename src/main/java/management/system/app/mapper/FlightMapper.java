package management.system.app.mapper;

import management.system.app.config.MapperConfig;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.dto.flight.FlightResponseDto;
import management.system.app.model.Flight;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class, uses = {AirplaneMapper.class, AirCompanyMapper.class})
public interface FlightMapper {
    FlightResponseDto toDto(Flight flight);

    Flight toModel(FlightRequestDto requestDto);
}
