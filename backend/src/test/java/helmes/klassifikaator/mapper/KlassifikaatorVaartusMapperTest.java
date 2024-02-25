package helmes.klassifikaator.mapper;

import helmes.klassifikaator.dto.KlassifikaatorVaartusDto;
import helmes.klassifikaator.model.KlassifikaatorVaartus;
import helmes.klassifikaator.repository.KlassifikaatorVaartusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class KlassifikaatorVaartusMapperTest {

    private final KlassifikaatorVaartusMapper mapper = Mappers.getMapper(KlassifikaatorVaartusMapper.class);

    @Autowired
    private KlassifikaatorVaartusRepository vaartusRepository;

    @BeforeEach
    public void generateDataToDb() {
        KlassifikaatorVaartus klassifikaatorVaartus = new KlassifikaatorVaartus();
        klassifikaatorVaartus.setVaartus("TEST-label");
        klassifikaatorVaartus.setKood("test_code_2");
        klassifikaatorVaartus.setKeelKood("EN");

        vaartusRepository.saveAndFlush(klassifikaatorVaartus);
    }

    @Test
    public void testMapping() {
        KlassifikaatorVaartusDto dto = new KlassifikaatorVaartusDto();
        dto.setId(1L);
        dto.setKood("test_code_2");
        dto.setKeelKood("EN");
        dto.setVaartus("TEST-label");

        KlassifikaatorVaartus klassifikaatorVaartus = mapper.fromDtoToEntity(dto);

        assertThat(klassifikaatorVaartus.getVaartus()).isEqualTo("TEST-label");
        assertThat(klassifikaatorVaartus.getKeelKood()).isEqualTo("EN");
    }

}