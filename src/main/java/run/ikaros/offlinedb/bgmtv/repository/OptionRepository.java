package run.ikaros.offlinedb.bgmtv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import run.ikaros.offlinedb.bgmtv.entity.OptionEntity;
import run.ikaros.offlinedb.bgmtv.enums.OptionKey;

import java.util.Optional;

public interface OptionRepository extends JpaRepository<OptionEntity, Long> {
    Optional<OptionEntity> findByKey(OptionKey key);
}
