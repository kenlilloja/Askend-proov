package helmes.klassifikaator.mapper;

import helmes.core.mapper.DtoAndEntityMapper;
import helmes.core.mapper.DtoAndEntityOverwriteMapper;
import helmes.klassifikaator.dto.KlassifikaatorVaartusDto;
import helmes.klassifikaator.model.KlassifikaatorVaartus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        disableSubMappingMethodsGeneration = true)
public interface KlassifikaatorVaartusMapper extends DtoAndEntityMapper<KlassifikaatorVaartusDto, KlassifikaatorVaartus>,
                                                             DtoAndEntityOverwriteMapper<KlassifikaatorVaartusDto, KlassifikaatorVaartus> {

}