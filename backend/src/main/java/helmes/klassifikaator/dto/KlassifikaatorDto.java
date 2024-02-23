package helmes.klassifikaator.dto;

import helmes.core.dto.BaseDto;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KlassifikaatorDto extends BaseDto {

    private Long id;
    private String domeenKood;
    private String kood;
    private Integer tasemeNr;
    private Boolean onYlemKategooria;
    private Integer jrkNr;
    private String label;
    private List<KlassifikaatorDto> children;
    private KlassifikaatorVaartusDto klassifikaatorVaartus;
}
