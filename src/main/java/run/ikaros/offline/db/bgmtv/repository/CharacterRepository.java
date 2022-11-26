package run.ikaros.offline.db.bgmtv.repository;

import org.springframework.data.repository.CrudRepository;
import run.ikaros.offline.db.bgmtv.entity.CharacterEntity;

public interface CharacterRepository extends CrudRepository<CharacterEntity, Long> {
}
