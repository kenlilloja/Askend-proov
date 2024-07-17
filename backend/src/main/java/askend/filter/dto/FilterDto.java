package askend.filter.dto;

import askend.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilterDto extends BaseDto {

    private Long id;
    private String name;
    private List<CriteriaDto> criterias;
}
