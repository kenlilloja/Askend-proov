package helmes.klassifikaator.repository;

import helmes.core.repository.BaseRepository;
import helmes.klassifikaator.model.Klassifikaator;

import java.util.List;

public interface KlassifikaatorRepository extends BaseRepository<Klassifikaator, Long> {

    List<Klassifikaator> findAllByDomeenKoodAndOnYlemKategooriaIsTrueOrderByJrkNr(String domeenKood);
}
