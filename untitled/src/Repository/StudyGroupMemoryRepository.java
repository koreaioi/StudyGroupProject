package Repository;

import Domain.StudyGroup;

import java.util.*;

public class StudyGroupMemoryRepository implements StudyGroupRepository {

    List<StudyGroup> studyGroups;

    public StudyGroupMemoryRepository() {
        studyGroups = new ArrayList<>();
    }


    @Override
    public StudyGroup save(StudyGroup studyGroup) {
        studyGroups.add(studyGroup);
        return studyGroup;
    }

    @Override
    public StudyGroup findById(String id) {
        StudyGroup findGroup = null;
        for (StudyGroup group : studyGroups) {
            if (group.getId().equals(id)){
                findGroup = group;
                break;
            }
        }
        return findGroup;
    }

    @Override
    public List<StudyGroup> findByName(String name) {
        List<StudyGroup> studylist = new ArrayList<>();
        for (StudyGroup group : studyGroups) {
            if (group.getName().equals(name)){
                studylist.add(group);
            }
        }
        return studylist;
    }

}
