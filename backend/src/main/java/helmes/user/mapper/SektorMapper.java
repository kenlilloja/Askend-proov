package helmes.user.mapper;

import helmes.core.mapper.DtoAndEntityMapper;
import helmes.core.mapper.DtoAndEntityOverwriteMapper;
import helmes.klassifikaator.mapper.KlassifikaatorMapper;
import helmes.user.dto.KasutajaSektorDto;
import helmes.user.model.KasutajaSektor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        disableSubMappingMethodsGeneration = true,
        uses = {KlassifikaatorMapper.class})
public interface SektorMapper extends DtoAndEntityMapper<KasutajaSektorDto, KasutajaSektor>,
                                              DtoAndEntityOverwriteMapper<KasutajaSektorDto, KasutajaSektor> {
}
