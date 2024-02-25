package helmes.klassifikaator.mapper;

import helmes.klassifikaator.dto.KlassifikaatorDto;
import helmes.klassifikaator.model.Klassifikaator;
import helmes.klassifikaator.model.KlassifikaatorVaartus;
import helmes.klassifikaator.repository.KlassifikaatorRepository;
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
class KlassifikaatorMapperTest {

    private final KlassifikaatorMapper mapper = Mappers.getMapper(KlassifikaatorMapper.class);

    @Autowired
    private KlassifikaatorVaartusRepository vaartusRepository;

    @Autowired
    private KlassifikaatorRepository klassifikaatorRepository;

    @BeforeEach
    public void generateDataToDb() {
        KlassifikaatorVaartus klassifikaatorVaartus = new KlassifikaatorVaartus();
        klassifikaatorVaartus.setVaartus("TEST-label");
        klassifikaatorVaartus.setKood("test_code_2");
        klassifikaatorVaartus.setKeelKood("EN");

        vaartusRepository.saveAndFlush(klassifikaatorVaartus);

        Klassifikaator klassifikaator2 = new Klassifikaator();
        klassifikaator2.setDomeenKood("test_domain");
        klassifikaator2.setKood("test_code_2");
        klassifikaator2.setTasemeNr(1);
        klassifikaator2.setOnYlemKategooria(true);
        klassifikaator2.setJrkNr(1);

        klassifikaatorRepository.saveAndFlush(klassifikaator2);
    }

    @Test
    public void testMapping() {
        KlassifikaatorDto dto = new KlassifikaatorDto();
        dto.setId(1L);
        dto.setDomeenKood("test_domain");
        dto.setKood("test_code_2");
        dto.setTasemeNr(1);
        dto.setOnYlemKategooria(true);
        dto.setJrkNr(1);
        dto.setLabel("TEST-label");

        Klassifikaator klassifikaator = mapper.fromDtoToEntity(dto);

        assertThat(klassifikaator.getJrkNr()).isEqualTo(1);
        assertThat(klassifikaator.getKood()).isEqualTo("test_code_2");
        assertThat(klassifikaator.getKlassifikaatorVaartus().getVaartus()).isEqualTo("TEST-label");
    }

}