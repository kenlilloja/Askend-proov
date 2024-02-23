package helmes.user.dto;

import helmes.core.dto.BaseDto;
import helmes.klassifikaator.dto.KlassifikaatorDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KasutajaSektorDto extends BaseDto {

    private Long id;
    private KlassifikaatorDto sektor;
}
