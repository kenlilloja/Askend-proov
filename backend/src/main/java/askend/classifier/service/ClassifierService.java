package askend.classifier.service;

import askend.classifier.dto.ClassifierDto;
import askend.classifier.mapper.ClassifierMapper;
import askend.classifier.repository.ClassifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassifierService {

    private final ClassifierRepository klassifikaatorRepository;
    private final ClassifierMapper mapper;
}
