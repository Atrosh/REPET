package by.repet.repositories;//Created by vladr on 20.12.2016.

import by.repet.domain.Course;
import by.repet.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Collection<Lesson> findByUserIdAndDateBetween(long userId, Date start, Date end);

    Collection<Lesson> findByUserIdOrCourseInAndDateBetween(long userId, List<Course> courses, Date start, Date end);

    Collection<Lesson> findByDateBetweenAndCourseIn(Date start, Date end, List<Course> courses);

    Collection<Lesson> findByDateBetween(Date start, Date end);
}
