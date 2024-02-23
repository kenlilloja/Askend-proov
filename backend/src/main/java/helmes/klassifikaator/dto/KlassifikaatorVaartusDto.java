package helmes.klassifikaator.dto;

import helmes.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KlassifikaatorVaartusDto extends BaseDto {

    private Long id;
    private String kood;
    private String vaartus;
    private String keelKood;
}
