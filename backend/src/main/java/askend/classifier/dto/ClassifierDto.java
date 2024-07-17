package askend.classifier.dto;

import askend.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassifierDto extends BaseDto {

    private String domainCode;
    private String code;
    private String parentCode;
    private List<ClassifierDto> subClassifiers;
    private ClassifierValueDto classifierValue;
}
