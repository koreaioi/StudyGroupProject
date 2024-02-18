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
    public List<StudyGroup> findAll() {
        return studyGroups;
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

    @Override
    public StudyGroup Update(int index, StudyGroup studyGroup) {
        studyGroups.remove(index);
        studyGroups.add(index, studyGroup);
        return studyGroup;
    }

    @Override
    public int findOneToIndex(String id) {
        for (StudyGroup group : studyGroups) {
            if (group.getId().equals(id)) {
                return studyGroups.indexOf(group);
            }
        }

        return -1;
    }

    @Override
    public void delete(String id) {
        for (StudyGroup group : studyGroups) {
            if (group.getId().equals(id)) {
                studyGroups.remove(group);
                break;
            }
        }
    }

}
