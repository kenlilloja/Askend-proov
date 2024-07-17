package askend.filter.mapper;

import askend.core.mapper.DtoAndEntityMapper;
import askend.core.mapper.DtoAndEntityOverwriteMapper;
import askend.filter.dto.CriteriaDto;
import askend.filter.model.Criteria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CriteriaMapper implements DtoAndEntityMapper<CriteriaDto, Criteria>,
                                        DtoAndEntityOverwriteMapper<CriteriaDto, Criteria> {

    public abstract CriteriaDto fromEntityToDto(Criteria entity);

    public abstract Criteria fromDtoToEntity(CriteriaDto dto);

}
