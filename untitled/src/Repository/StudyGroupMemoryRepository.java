package Repository;

import Domain.StudyGroup;

import java.util.*;

public class StudyGroupMemoryRepository implements StudyGroupRepository {

    List<StudyGroup> studyGroups;

    public StudyGroupMemoryRepository() {
        studyGroups = new ArrayList<>();
    }


    @Override
    public void save(StudyGroup studyGroup) {
        studyGroups.add(studyGroup);
    }
}
