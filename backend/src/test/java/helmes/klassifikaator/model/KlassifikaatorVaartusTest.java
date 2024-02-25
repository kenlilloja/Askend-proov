package helmes.klassifikaator.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class KlassifikaatorVaartusTest {

    @Test
    public void testEntityMapping() {
        KlassifikaatorVaartus klassifikaatorVaartus = new KlassifikaatorVaartus();
        klassifikaatorVaartus.setVaartus("TEST-label");
        klassifikaatorVaartus.setKood("test_code_2");
        klassifikaatorVaartus.setKeelKood("EN");

        assertEquals(klassifikaatorVaartus.getKood(), "test_code_2");
        assertEquals(klassifikaatorVaartus.getKeelKood(), "EN");
    }
}