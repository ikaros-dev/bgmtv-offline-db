package run.ikaros.offline.db.bgmtv.repository;

import org.springframework.data.repository.CrudRepository;
import run.ikaros.offline.db.bgmtv.entity.EpisodeEntity;

public interface EpisodeRepository extends CrudRepository<EpisodeEntity, Long> {
}
