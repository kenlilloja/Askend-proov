package askend.filter.mapper;

import askend.core.mapper.DtoAndEntityMapper;
import askend.core.mapper.DtoAndEntityOverwriteMapper;
import askend.filter.dto.CriteriaDto;
import askend.filter.model.Criteria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriteriaMapper extends DtoAndEntityMapper<CriteriaDto, Criteria>,
                                        DtoAndEntityOverwriteMapper<CriteriaDto, Criteria> {
}
