package helmes.user.repository;

import helmes.core.repository.BaseRepository;
import helmes.user.model.KasutajaSektor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface KasutajaSektorRepository extends BaseRepository<KasutajaSektor, Long> {

}
