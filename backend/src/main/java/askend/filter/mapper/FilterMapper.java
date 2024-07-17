package askend.filter.mapper;

import askend.core.mapper.DtoAndEntityMapper;
import askend.core.mapper.DtoAndEntityOverwriteMapper;
import askend.filter.dto.FilterDto;
import askend.filter.model.Filter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {CriteriaMapper.class})
public abstract class FilterMapper implements DtoAndEntityMapper<FilterDto, Filter>,
                                      DtoAndEntityOverwriteMapper<FilterDto, Filter> {

    public abstract FilterDto fromEntityToDto(Filter entity);

    public abstract Filter fromDtoToEntity(FilterDto dto);

}