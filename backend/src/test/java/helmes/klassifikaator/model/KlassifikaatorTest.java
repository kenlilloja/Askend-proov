package helmes.klassifikaator.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class KlassifikaatorTest {

    @Test
    public void testEntityMapping() {
        Klassifikaator klassifikaator = new Klassifikaator();
        klassifikaator.setDomeenKood("test_domain");
        klassifikaator.setKood("test_code");
        klassifikaator.setTasemeNr(123);
        klassifikaator.setOnYlemKategooria(true);
        klassifikaator.setJrkNr(1);

        assertEquals(klassifikaator.getKood(), "test_code");
        assertEquals(klassifikaator.getTasemeNr(), 123);
        assertTrue(klassifikaator.getOnYlemKategooria());
    }
}