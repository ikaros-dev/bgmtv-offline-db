package run.ikaros.offlinedb.bgmtv.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import run.ikaros.offlinedb.bgmtv.entity.EpisodeEntity;
import run.ikaros.offlinedb.bgmtv.repository.EpisodeRepository;

@Slf4j
@Service
public class EpisodeService {
    private final EpisodeRepository episodeRepository;

    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }


    public void save(EpisodeEntity episodeEntity) {
        episodeRepository.save(episodeEntity);
    }
}
