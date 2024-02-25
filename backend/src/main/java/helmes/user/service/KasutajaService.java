package helmes.user.service;

import helmes.user.dto.KasutajaInfoDto;
import helmes.user.model.KasutajaInfo;
import helmes.user.model.KasutajaSektor;
import helmes.user.repository.KasutajaInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import helmes.user.mapper.KasutajaMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class KasutajaService {

    private final KasutajaInfoRepository kasutajaRepository;
    private final KasutajaMapper mapper;

    public KasutajaInfoDto saveUserInfo(KasutajaInfoDto dto) {
        KasutajaInfo entity = mapper.fromDtoToEntity(dto);

        for (KasutajaSektor sektor : entity.getSektorid()) {
            sektor.setKasutaja(entity);
        }

        entity = kasutajaRepository.save(entity);

        return mapper.fromEntityToDto(entity);
    }

    public KasutajaInfoDto getUserInfo() {
        List<KasutajaInfo> entities = (List<KasutajaInfo>) kasutajaRepository.findAll();
        if (!entities.isEmpty()) {
            return mapper.fromEntityToDto(entities.get(0));
        }
        return null;
    }
}
