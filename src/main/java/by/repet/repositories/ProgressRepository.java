package by.repet.repositories;//Created by vladr on 30.04.2017.

import by.repet.domain.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Collection<Progress> findAllByUserIdAndStepParagraphUnitCourseId(long userId, long courseId);
    Integer countAllByUserIdAndStepParagraphUnitCourseId(long userId, long courseId);
}
