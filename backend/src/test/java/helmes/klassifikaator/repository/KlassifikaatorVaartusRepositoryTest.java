package helmes.klassifikaator.repository;

import helmes.klassifikaator.model.KlassifikaatorVaartus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class KlassifikaatorVaartusRepositoryTest {

    @Autowired
    private KlassifikaatorVaartusRepository vaartusRepository;

    @Test
    public void testAddingEntities() {
        KlassifikaatorVaartus klassifikaatorVaartus = new KlassifikaatorVaartus();
        klassifikaatorVaartus.setVaartus("TEST");
        klassifikaatorVaartus.setKood("test_code_2");
        klassifikaatorVaartus.setKeelKood("EN");

        KlassifikaatorVaartus klassifikaatorVaartus2 = new KlassifikaatorVaartus();
        klassifikaatorVaartus2.setVaartus("TEST");
        klassifikaatorVaartus2.setKood("test_code_1");
        klassifikaatorVaartus2.setKeelKood("EN");

        vaartusRepository.saveAllAndFlush(List.of(klassifikaatorVaartus2, klassifikaatorVaartus));

        List<KlassifikaatorVaartus> entities = vaartusRepository.findAll();

        assertThat(entities.size()).isEqualTo(2);
    }


}