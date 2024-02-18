package Repository;

import Domain.StudyGroup;

import java.util.*;

public interface StudyGroupRepository {

    StudyGroup save(StudyGroup studyGroup);

    StudyGroup findById(String id);

    List<StudyGroup> findByName(String name);

    List<StudyGroup> findAll();

    int findOneToIndex(String id);

    StudyGroup Update(int index, StudyGroup studyGroup);

    void delete(String id);

}
