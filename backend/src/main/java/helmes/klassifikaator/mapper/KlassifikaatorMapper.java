package helmes.klassifikaator.mapper;

import helmes.core.mapper.DtoAndEntityMapper;
import helmes.core.mapper.DtoAndEntityOverwriteMapper;
import helmes.klassifikaator.dto.KlassifikaatorDto;
import helmes.klassifikaator.model.Klassifikaator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        disableSubMappingMethodsGeneration = true,
        uses = KlassifikaatorVaartusMapper.class)
public abstract class KlassifikaatorMapper implements DtoAndEntityMapper<KlassifikaatorDto, Klassifikaator>,
                                                      DtoAndEntityOverwriteMapper<KlassifikaatorDto, Klassifikaator> {

    @Mapping(target = "label", source = "klassifikaatorVaartus.vaartus")
    @Mapping(target = "children", source = "alamKlassifikaatorid")
    public abstract KlassifikaatorDto fromEntityToDto(Klassifikaator entity);

    @Mapping(target = "klassifikaatorVaartus.vaartus", source = "label")
    @Mapping(target = "alamKlassifikaatorid", source = "children")
    public abstract Klassifikaator fromDtoToEntity(KlassifikaatorDto dto);
}
