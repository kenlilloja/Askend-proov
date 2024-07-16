package askend.classifier.mapper;

import askend.classifier.model.Classifier;
import askend.core.mapper.DtoAndEntityMapper;
import askend.core.mapper.DtoAndEntityOverwriteMapper;
import askend.classifier.dto.ClassifierDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        disableSubMappingMethodsGeneration = true,
        uses = ClassifierValueMapper.class)
public abstract class ClassifierMapper implements DtoAndEntityMapper<ClassifierDto, Classifier>,
                                                  DtoAndEntityOverwriteMapper<ClassifierDto, Classifier> {
    public abstract ClassifierDto fromEntityToDto(Classifier entity);

    public abstract Classifier fromDtoToEntity(ClassifierDto dto);
}
