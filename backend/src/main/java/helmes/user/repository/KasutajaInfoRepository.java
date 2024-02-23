package helmes.user.repository;

import helmes.core.repository.BaseRepository;
import helmes.user.model.KasutajaInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface KasutajaInfoRepository extends BaseRepository<KasutajaInfo, Long> {

}
