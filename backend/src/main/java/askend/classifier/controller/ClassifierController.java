package askend.classifier.controller;

import askend.classifier.dto.ClassifierDto;
import askend.classifier.service.ClassifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/classifier")
@RequiredArgsConstructor
public class ClassifierController {

    private final ClassifierService service;

    @GetMapping("/{domainCode}")
    public List<ClassifierDto> getAllKlassifikaatoridByDomainCode(@PathVariable String domainCode) {
        return null; //service.getAllByDomainCodeAndIsYlemKategooria(domainCode);
    }
}
