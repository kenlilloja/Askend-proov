package helmes.user.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
public class KasutajaInfoTest {

    @Test
    void testEntityMappings() {
        KasutajaInfo kasutajaInfo = new KasutajaInfo();
        kasutajaInfo.setNimi("John Doe");
        kasutajaInfo.setId(1L);
        kasutajaInfo.setOnNousTingimustega(true);

        assertEquals(1L, kasutajaInfo.getId());
        assertEquals("John Doe", kasutajaInfo.getNimi());
        assertTrue(kasutajaInfo.getOnNousTingimustega());
    }
}
