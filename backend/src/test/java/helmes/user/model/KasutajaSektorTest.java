package helmes.user.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class KasutajaSektorTest {

    @Test
    void testEntityMappings() {
        KasutajaSektor kasutajasektor = new KasutajaSektor();
        kasutajasektor.setKasutaja(null);
        kasutajasektor.setId(1L);

        assertEquals(1L, kasutajasektor.getId());
    }
}
