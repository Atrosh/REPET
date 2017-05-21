package by.repet.repositories;//Created by vladr on 30.04.2017.

import by.repet.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StepRepository extends JpaRepository<Step, Long> {
    Collection<Step> getAllByParagraphId(long paragraphId);
    Collection<Step> findAllByParagraphUnitCourseIdOrderByParagraphUnitSerialAscParagraphSerialAscSerialAsc(long courseId);
    Integer countAllByParagraphUnitCourseId(long courseId);
    Integer countAllByParagraphId(long paragraphId);
}
