package helmes.klassifikaator.service;

import helmes.klassifikaator.dto.KlassifikaatorDto;
import helmes.klassifikaator.mapper.KlassifikaatorMapper;
import helmes.klassifikaator.repository.KlassifikaatorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KlassifikaatorService {

    private final KlassifikaatorRepository klassifikaatorRepository;
    private final KlassifikaatorMapper mapper;


    public List<KlassifikaatorDto> getAllByDomainCodeAndIsYlemKategooria(String domeenKood) {
        return mapper.fromEntityToDto(klassifikaatorRepository.findAllByDomeenKoodAndOnYlemKategooriaIsTrueOrderByJrkNr(domeenKood));
    }
}
