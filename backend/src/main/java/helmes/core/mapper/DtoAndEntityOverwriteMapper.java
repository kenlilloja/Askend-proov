package helmes.core.mapper;

import org.mapstruct.MappingTarget;

public interface DtoAndEntityOverwriteMapper<DTO, ENTITY> extends HelmesMapper {

    void fromDtoToEntity(DTO dto, @MappingTarget ENTITY entity);
}
