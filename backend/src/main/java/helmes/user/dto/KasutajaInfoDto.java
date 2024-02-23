package helmes.user.dto;

import helmes.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class KasutajaInfoDto extends BaseDto {

    private Long id;
    private String nimi;
    private Boolean onNousTingimustega = false;
    private List<KasutajaSektorDto> sektorid;
}
