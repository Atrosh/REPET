package by.repet.services;//Created by vladr on 20.12.2016.

import by.repet.domain.Lesson;

import java.util.ArrayList;
import java.util.Collection;

public interface LessonService {
    Lesson getLesson(Long lessonId);

    Collection<Lesson> getAll();

    Collection<Lesson> getTodayLessons();

    ArrayList<Collection<Lesson>> getWeekLessons();

    void add(Lesson lesson);

    void remove(Long lessonId);
}