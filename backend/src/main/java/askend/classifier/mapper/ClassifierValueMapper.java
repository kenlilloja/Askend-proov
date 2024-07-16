package askend.classifier.mapper;

import askend.classifier.dto.ClassifierValueDto;
import askend.classifier.model.ClassifierValue;
import askend.core.mapper.DtoAndEntityMapper;
import askend.core.mapper.DtoAndEntityOverwriteMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        disableSubMappingMethodsGeneration = true)
public interface ClassifierValueMapper extends DtoAndEntityMapper<ClassifierValueDto, ClassifierValue>,
                                               DtoAndEntityOverwriteMapper<ClassifierValueDto, ClassifierValue> {

}