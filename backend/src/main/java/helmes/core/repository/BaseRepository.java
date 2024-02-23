package helmes.core.repository;

import helmes.core.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel, ID> extends JpaRepository<T, ID> {
}
