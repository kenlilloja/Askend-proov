package helmes.user.mapper;

import helmes.core.mapper.DtoAndEntityMapper;
import helmes.core.mapper.DtoAndEntityOverwriteMapper;
import helmes.user.model.KasutajaInfo;
import org.mapstruct.Mapper;
import helmes.user.dto.KasutajaInfoDto;

@Mapper(componentModel = "spring",
        uses = {SektorMapper.class})
public interface KasutajaMapper extends DtoAndEntityMapper<KasutajaInfoDto, KasutajaInfo>,
        DtoAndEntityOverwriteMapper<KasutajaInfoDto, KasutajaInfo> {
}
