package by.repet.services;//Created by vladr on 14.05.2017.

import by.repet.domain.Step;

import java.util.Collection;

public interface StepService {
    Step getStep(Long stepId);

    Collection<Step> getAll();

    Collection<Step> getAllByParagraphId(Long paragraphId);

    Collection<Step> getAllByCourseId(Long courseId);

    Integer getCourseStepsCount(Long courseId);

    Integer getParagraphStepsCount(Long paragraphId);

    Step add(Step step);

    void remove(Long stepId);

    void saveAll(Collection<Step> steps);
}
