package askend.filter.dto;

import askend.classifier.dto.ClassifierDto;
import askend.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriteriaDto extends BaseDto {

    private Long id;
    private FilterDto filter;
    private ClassifierDto criteriaType;
    private ClassifierDto condition;
    private String value;
}
