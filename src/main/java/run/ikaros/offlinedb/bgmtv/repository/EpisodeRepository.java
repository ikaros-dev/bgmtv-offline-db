package run.ikaros.offlinedb.bgmtv.repository;

import org.springframework.data.repository.CrudRepository;
import run.ikaros.offlinedb.bgmtv.entity.EpisodeEntity;

public interface EpisodeRepository extends CrudRepository<EpisodeEntity, Long> {
}
