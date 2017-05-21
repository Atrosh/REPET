package by.repet.services;//Created by vladr on 20.12.2016.

import by.repet.common.LessonDto;
import by.repet.domain.Lesson;

import java.util.ArrayList;
import java.util.Collection;

public interface LessonService {
    Lesson getLesson(Long lessonId);

    Collection<Lesson> getAll();

    Collection<Lesson> getTodayLessons();

    ArrayList<Collection<Lesson>> getWeekLessons();

    Lesson add(Lesson lesson);

    void createLessons(LessonDto lessonDto);

    void remove(Long lessonId);
}
