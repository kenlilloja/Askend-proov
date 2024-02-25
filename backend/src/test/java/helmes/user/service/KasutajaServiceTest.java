package helmes.user.service;

import helmes.klassifikaator.dto.KlassifikaatorDto;
import helmes.klassifikaator.dto.KlassifikaatorVaartusDto;
import helmes.klassifikaator.model.Klassifikaator;
import helmes.klassifikaator.model.KlassifikaatorVaartus;
import helmes.klassifikaator.repository.KlassifikaatorRepository;
import helmes.klassifikaator.repository.KlassifikaatorVaartusRepository;
import helmes.user.dto.KasutajaInfoDto;
import helmes.user.dto.KasutajaSektorDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class KasutajaServiceTest {

    @Mock
    private KasutajaService kasutajaService;

    @Autowired
    private KlassifikaatorRepository klassifikaatorRepository;

    @Autowired
    private KlassifikaatorVaartusRepository klassifikaatorVaartusRepository;

    @BeforeEach
    public void generateDataToDb() {
        KlassifikaatorVaartus klassifikaatorVaartus = new KlassifikaatorVaartus();
        klassifikaatorVaartus.setId(1L);
        klassifikaatorVaartus.setKood("TEST_KOOD");
        klassifikaatorVaartus.setKeelKood("EN");
        klassifikaatorVaartus.setVaartus("Test label");

        klassifikaatorVaartusRepository.saveAndFlush(klassifikaatorVaartus);


        Klassifikaator klassifikaator = new Klassifikaator();
        klassifikaator.setId(1L);
        klassifikaator.setDomeenKood("TEST_DOMAIN");
        klassifikaator.setKood("TEST_KOOD");
        klassifikaator.setYlemKood(null);
        klassifikaator.setTasemeNr(1);
        klassifikaator.setOnYlemKategooria(false);
        klassifikaator.setJrkNr(1);
        klassifikaator.setKlassifikaatorVaartus(klassifikaatorVaartus);

        klassifikaatorRepository.saveAndFlush(klassifikaator);
    }


    @Test
    void testSaveUserInfo() {
        KasutajaInfoDto dto = new KasutajaInfoDto();
        dto.setId(1L);
        dto.setNimi("Test user");

        KlassifikaatorVaartusDto klassifikaatorVaartusDto = new KlassifikaatorVaartusDto();
        klassifikaatorVaartusDto.setId(1L);
        klassifikaatorVaartusDto.setKood("TEST_KOOD");
        klassifikaatorVaartusDto.setKeelKood("EN");
        klassifikaatorVaartusDto.setVaartus("Test label");


        KlassifikaatorDto klassifikaatorDto = new KlassifikaatorDto();
        klassifikaatorDto.setId(1L);
        klassifikaatorDto.setDomeenKood("TEST_DOMAIN");
        klassifikaatorDto.setKood("TEST_KOOD");
        klassifikaatorDto.setTasemeNr(1);
        klassifikaatorDto.setOnYlemKategooria(false);
        klassifikaatorDto.setJrkNr(1);
        klassifikaatorDto.setLabel("Test label");
        klassifikaatorDto.setChildren(new ArrayList<>());
        klassifikaatorDto.setKlassifikaatorVaartus(klassifikaatorVaartusDto);

        KasutajaSektorDto kasutajaSektorDto = new KasutajaSektorDto();
        kasutajaSektorDto.setSektor(klassifikaatorDto);
        kasutajaSektorDto.setId(1L);

        dto.setSektorid(List.of(kasutajaSektorDto));


        kasutajaService.saveUserInfo(dto);
    }
}
