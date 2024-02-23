package helmes.klassifikaator.repository;

import helmes.core.repository.BaseRepository;
import helmes.klassifikaator.model.Klassifikaator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface KlassifikaatorRepository extends BaseRepository<Klassifikaator, Long> {

    List<Klassifikaator> findAllByDomeenKoodAndOnYlemKategooriaIsTrueOrderByJrkNr(String domeenKood);
}
