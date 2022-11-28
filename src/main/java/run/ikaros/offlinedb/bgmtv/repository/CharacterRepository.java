package run.ikaros.offlinedb.bgmtv.repository;

import org.springframework.data.repository.CrudRepository;
import run.ikaros.offlinedb.bgmtv.entity.CharacterEntity;

public interface CharacterRepository extends CrudRepository<CharacterEntity, Long> {
}
