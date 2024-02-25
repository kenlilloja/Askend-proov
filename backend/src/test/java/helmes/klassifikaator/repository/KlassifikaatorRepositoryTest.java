package helmes.klassifikaator.repository;

import helmes.klassifikaator.model.Klassifikaator;
import helmes.klassifikaator.model.KlassifikaatorVaartus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class KlassifikaatorRepositoryTest {

    @Autowired
    private KlassifikaatorRepository klassifikaatorRepository;

    @Autowired
    private KlassifikaatorVaartusRepository vaartusRepository;

    @Test
    public void testSaveKlassifikaator() {
        Klassifikaator klassifikaator = new Klassifikaator();
        klassifikaator.setDomeenKood("test_domain");
        klassifikaator.setKood("test_code");
        klassifikaator.setTasemeNr(1);
        klassifikaator.setOnYlemKategooria(true);
        klassifikaator.setJrkNr(1);

        klassifikaator = klassifikaatorRepository.save(klassifikaator);

        assertThat(klassifikaator.getId()).isNotNull();
    }

    @Test
    public void testFindAllByDomeenKoodAndOnYlemKategooriaIsTrueOrderByJrkNr() {
        KlassifikaatorVaartus klassifikaatorVaartus = new KlassifikaatorVaartus();
        klassifikaatorVaartus.setVaartus("TEST");
        klassifikaatorVaartus.setKood("test_code_2");
        klassifikaatorVaartus.setKeelKood("EN");

        KlassifikaatorVaartus klassifikaatorVaartus2 = new KlassifikaatorVaartus();
        klassifikaatorVaartus2.setVaartus("TEST");
        klassifikaatorVaartus2.setKood("test_code_1");
        klassifikaatorVaartus2.setKeelKood("EN");

        vaartusRepository.saveAllAndFlush(List.of(klassifikaatorVaartus2, klassifikaatorVaartus));

        Klassifikaator klassifikaator1 = new Klassifikaator();
        klassifikaator1.setDomeenKood("test_domain");
        klassifikaator1.setKood("test_code_1");
        klassifikaator1.setTasemeNr(1);
        klassifikaator1.setOnYlemKategooria(true);
        klassifikaator1.setJrkNr(2);

        Klassifikaator klassifikaator2 = new Klassifikaator();
        klassifikaator2.setDomeenKood("test_domain");
        klassifikaator2.setKood("test_code_2");
        klassifikaator2.setTasemeNr(1);
        klassifikaator2.setOnYlemKategooria(true);
        klassifikaator2.setJrkNr(1);

        klassifikaatorRepository.saveAllAndFlush(List.of(klassifikaator1, klassifikaator2));

        List<Klassifikaator> klassifikaators = klassifikaatorRepository.findAllByDomeenKoodAndOnYlemKategooriaIsTrueOrderByJrkNr("test_domain");

        assertThat(klassifikaators.size()).isEqualTo(2);
        assertThat(klassifikaators.get(0).getJrkNr()).isEqualTo(1);
        assertThat(klassifikaators.get(1).getJrkNr()).isEqualTo(2);
    }
}
