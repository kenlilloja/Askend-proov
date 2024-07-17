package askend.classifier.service;

import askend.classifier.dto.ClassifierDto;
import askend.classifier.mapper.ClassifierMapper;
import askend.classifier.repository.ClassifierRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassifierService {

    private final ClassifierRepository classifierRepository;
    private final ClassifierMapper mapper;

    public List<ClassifierDto> getAllClassifiersByDomainCode(String domainCode) {
        return mapper.fromEntityToDto(
                classifierRepository.getAllByDomainCode(domainCode)
        );
    }
}
