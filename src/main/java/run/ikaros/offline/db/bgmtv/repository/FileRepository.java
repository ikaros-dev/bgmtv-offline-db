package run.ikaros.offline.db.bgmtv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import run.ikaros.offline.db.bgmtv.entity.FileEntity;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    Optional<FileEntity> findByMd5(String md5);
}
