package askend.filter.mapper;

import askend.core.mapper.DtoAndEntityMapper;
import askend.core.mapper.DtoAndEntityOverwriteMapper;
import askend.filter.dto.FilterDto;
import askend.filter.model.Filter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {CriteriaMapper.class})
public interface FilterMapper extends DtoAndEntityMapper<FilterDto, Filter>,
                                      DtoAndEntityOverwriteMapper<FilterDto, Filter> {
}
