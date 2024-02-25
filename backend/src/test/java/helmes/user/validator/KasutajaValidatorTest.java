package helmes.user.validator;

import helmes.user.dto.KasutajaInfoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class KasutajaValidatorTest {

    @Mock
    private KasutajaValidator kasutajaValidator;

    private KasutajaInfoDto kasutajaInfoDto;
    private Errors errors;

    @BeforeEach
    void setUp() {
        kasutajaValidator = new KasutajaValidator();
        kasutajaInfoDto = new KasutajaInfoDto();
        errors = new BeanPropertyBindingResult(kasutajaInfoDto, "kasutajaInfoDto");
    }

    @Test
    void testSupports() {
        assertTrue(kasutajaValidator.supports(KasutajaInfoDto.class));
        assertFalse(kasutajaValidator.supports(Object.class));
    }

    @Test
    void testValidateWithNullNimi() {
        kasutajaInfoDto.setOnNousTingimustega(true);

        kasutajaValidator.validate(kasutajaInfoDto, errors);

        assertNotNull(errors);
    }

    @Test
    void testValidateWithNullOnNousTingimustega() {
        kasutajaInfoDto.setNimi("John Doe");

        kasutajaValidator.validate(kasutajaInfoDto, errors);

        assertNotNull(errors);

        assertEquals(1, errors.getAllErrors().size());
    }

    @Test
    void testValidateWithEmptySektorid() {
        kasutajaInfoDto.setNimi("John Doe");
        kasutajaInfoDto.setOnNousTingimustega(true);

        kasutajaValidator.validate(kasutajaInfoDto, errors);

        assertNotNull(errors);
        assertEquals(1, errors.getFieldErrors("sektorid").size());
    }
}
