package Service;

import Domain.StudyGroup;
import Repository.StudyGroupMemoryRepository;
import Repository.StudyGroupRepository;

public class StudyGroupService {
    StudyGroupRepository studyGroupRepository;

    public StudyGroupService() {
        studyGroupRepository = new StudyGroupMemoryRepository();
    }

    public String register(StudyGroup studyGroup) {

        studyGroupRepository.save(studyGroup);
        return studyGroup.getId();
    }

}
