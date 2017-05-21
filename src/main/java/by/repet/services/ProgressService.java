package by.repet.services;//Created by vladr on 20.05.2017.

import by.repet.domain.Progress;

import java.util.Collection;

public interface ProgressService {
    Progress findOne(Long id);

    Progress save(Progress progress);

    void remove(Long id);

    Collection<Progress> findByCourseId(Long courseId);

    Integer getCountByCourseId(Long courseId);
}
