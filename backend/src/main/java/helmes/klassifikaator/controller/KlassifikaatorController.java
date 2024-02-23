package helmes.klassifikaator.controller;

import helmes.klassifikaator.dto.KlassifikaatorDto;
import helmes.klassifikaator.service.KlassifikaatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/klassifikaator")
@AllArgsConstructor
public class KlassifikaatorController {

    private final KlassifikaatorService service;

    @GetMapping("/{domainCode}")
    public List<KlassifikaatorDto> getAllKlassifikaatoridByDomainCode(@PathVariable String domainCode) {
        return service.getAllByDomainCodeAndIsYlemKategooria(domainCode);
    }
}
