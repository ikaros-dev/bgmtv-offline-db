package run.ikaros.offlinedb.bgmtv.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import run.ikaros.offlinedb.bgmtv.entity.CharacterEntity;
import run.ikaros.offlinedb.bgmtv.repository.CharacterRepository;

@Slf4j
@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public void save(CharacterEntity characterEntity) {
        characterRepository.save(characterEntity);
    }
}
