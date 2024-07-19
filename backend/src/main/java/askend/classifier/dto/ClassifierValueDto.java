package askend.classifier.dto;

import askend.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassifierValueDto extends BaseDto {

    private Long id;
    private String code;
    private String value;
}
