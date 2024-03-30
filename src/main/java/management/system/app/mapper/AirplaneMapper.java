package management.system.app.mapper;

import management.system.app.config.MapperConfig;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.dto.airplane.AirplaneResponseDto;
import management.system.app.model.Airplane;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface AirplaneMapper {
    @Mapping(target = "airCompanyId", source = "airCompany.id")
    AirplaneResponseDto toDto(Airplane airplane);

    Airplane toModel(AirplaneRequestDto requestDto);
}
