package askend.filter.service;

import askend.filter.dto.FilterDto;
import askend.filter.mapper.FilterMapper;
import askend.filter.model.Criteria;
import askend.filter.model.Filter;
import askend.filter.repository.FilterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FilterService {

    private final FilterRepository filterRepository;
    private final FilterMapper mapper;

    public List<FilterDto> getAllFilters() {
        return mapper.fromEntityToDto(filterRepository.findAll());
    }

    public FilterDto saveFilter(FilterDto filterDto) {
        Filter filter = mapper.fromDtoToEntity(filterDto);

        for (Criteria criteria : filter.getCriterias()) {
            criteria.setFilter(filter);
        }

        filter.getSelectedCriteria().setFilter(filter);

        filter = filterRepository.save(filter);

        return mapper.fromEntityToDto(filter);
    }

}
