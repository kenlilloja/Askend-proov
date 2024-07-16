package askend.core.mapper;

import org.mapstruct.MappingTarget;

public interface DtoAndEntityOverwriteMapper<DTO, ENTITY> extends AskendMapper {

    void fromDtoToEntity(DTO dto, @MappingTarget ENTITY entity);
}
