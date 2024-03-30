package management.system.app.mapper;

import management.system.app.config.MapperConfig;
import management.system.app.dto.air.company.AirCompanyRequestDto;
import management.system.app.dto.air.company.AirCompanyResponseDto;
import management.system.app.model.AirCompany;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AirCompanyMapper {
    AirCompanyResponseDto toDto(AirCompany airCompany);

    AirCompany toModel(AirCompanyRequestDto requestDto);

}
