package Service;

import Domain.StudyGroup;
import Repository.StudyGroupMemoryRepository;
import Repository.StudyGroupRepository;

import java.util.*;

public class StudyGroupService {
    StudyGroupRepository studyGroupRepository;

    public StudyGroupService() {
        studyGroupRepository = new StudyGroupMemoryRepository();
    }

    public String register(StudyGroup studyGroup) {
        return studyGroupRepository.save(studyGroup).getId();
    }

    public List<StudyGroup> findAll() {
        return studyGroupRepository.findAll();
    }

    public StudyGroup findById(String id) {
        return studyGroupRepository.findById(id);
    }

    public List<StudyGroup> findByName(String name) {
        return studyGroupRepository.findByName(name);
    }

}
