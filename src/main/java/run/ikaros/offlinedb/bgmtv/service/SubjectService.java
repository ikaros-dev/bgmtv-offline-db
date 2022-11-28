package run.ikaros.offlinedb.bgmtv.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import run.ikaros.offlinedb.bgmtv.entity.SubjectEntity;
import run.ikaros.offlinedb.bgmtv.repository.SubjectRepository;

@Slf4j
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void save(SubjectEntity subjectEntity) {
        subjectRepository.save(subjectEntity);
    }
}
