package run.ikaros.offline.db.bgmtv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import run.ikaros.offline.db.bgmtv.entity.OptionEntity;
import run.ikaros.offline.db.bgmtv.enums.OptionKey;

import java.util.Optional;

public interface OptionRepository extends JpaRepository<OptionEntity, Long> {
    Optional<OptionEntity> findByKey(OptionKey key);
}
