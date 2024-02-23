package helmes.klassifikaator.repository;

import helmes.core.repository.BaseRepository;
import helmes.klassifikaator.model.KlassifikaatorVaartus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface KlassifikaatorVaartusRepository extends BaseRepository<KlassifikaatorVaartus, Long> {
}
