package by.repet.repositories;//Created by vladr on 20.12.2016.

import by.repet.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
