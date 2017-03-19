package by.repet.services.Impl;//Created by vladr on 20.12.2016.

import by.repet.domain.Lesson;
import by.repet.repositories.LessonRepository;
import by.repet.services.LessonService;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Lesson getLesson(Long lessonId) {
        return lessonRepository.findOne(lessonId);
    }

    @Override
    public Collection<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Collection<Lesson> getTodayLessons() {
        return lessonRepository.findByDateBetween(DateTime.now().minusDays(1).toDate(), DateTime.now().plus(1).toDate());
    }

    @Override
    public ArrayList<Collection<Lesson>> getWeekLessons() {
        ArrayList<Collection<Lesson>> days = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        for (int i = 1; i < 8; i++) {
            c.set(Calendar.DAY_OF_WEEK, i + 1);
            days.add(lessonRepository.findAll().stream()
                    .filter(lesson -> DateUtils.isSameDay(lesson.getDate(), c.getTime()))
                    .collect(Collectors.toList()));
        }
        return days;
    }


    @Override
    public void add(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void remove(Long lessonId) {
        lessonRepository.delete(lessonId);
    }
}
