package askend.core.mapper;

import java.util.List;

public interface DtoAndEntityMapper<DTO, ENTITY> extends AskendMapper {

    ENTITY fromDtoToEntity(DTO dto);

    DTO fromEntityToDto(ENTITY entity);

    List<ENTITY> fromDtoToEntity(List<DTO> dtoList);

    List<DTO> fromEntityToDto(List<ENTITY> entityList);
}
