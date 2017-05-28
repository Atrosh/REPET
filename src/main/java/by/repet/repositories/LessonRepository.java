package by.repet.repositories;//Created by vladr on 20.12.2016.

import by.repet.domain.Course;
import by.repet.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Collection<Lesson> findByDateBetweenAndUserId(Date start, Date end, long userId);

    @Query("SELECT l FROM Lesson l WHERE l.date BETWEEN ?1 AND ?2 AND (l.user.id = ?3 or l.course.id in ?4)")
    Collection<Lesson> findByDateBetweenAndUserIdAndCourseIn(Date start, Date end, long userId, List<Long> courses);

    Collection<Lesson> findByDateBetweenAndCourseIn(Date start, Date end, List<Course> courses);

    Collection<Lesson> findByDateBetween(Date start, Date end);
}
