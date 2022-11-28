package run.ikaros.offlinedb.bgmtv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import run.ikaros.offlinedb.bgmtv.entity.FileEntity;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    Optional<FileEntity> findByMd5(String md5);
}
