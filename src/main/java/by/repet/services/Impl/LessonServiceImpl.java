package by.repet.services.Impl;//Created by vladr on 20.12.2016.

import by.repet.common.LessonDto;
import by.repet.domain.Course;
import by.repet.domain.Lesson;
import by.repet.domain.User;
import by.repet.repositories.LessonRepository;
import by.repet.services.LessonService;
import by.repet.services.UserContextService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final UserContextService userContextService;

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
        User user = userContextService.getCurrentUser();
        Date since = DateTime.now().withTimeAtStartOfDay().toDate();
        Date till = DateTime.now().withTimeAtStartOfDay().plusDays(1).toDate();
        return lessonRepository.findByDateBetweenAndUserIdAndCourseIn(since, till, user.getId(),
                getCourseId(user));
    }

    @Override
    public ArrayList<Collection<Lesson>> getWeekLessons() {
        User user = userContextService.getCurrentUser();
        ArrayList<Collection<Lesson>> days = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        Collection<Lesson> lessons = lessonRepository.findByDateBetweenAndUserIdAndCourseIn(
                DateTime.now().minusDays(7).toDate(), DateTime.now().plusDays(7).toDate(),
                user.getId(), getCourseId(user));
        for (int i = 1; i < 8; i++) {
            c.set(Calendar.DAY_OF_WEEK, i + 1);
            days.add(lessons.stream()
                    .filter(lesson -> DateUtils.isSameDay(lesson.getDate(), c.getTime()))
                    .collect(Collectors.toList()));
        }
        return days;
    }

    @Override
    public Lesson add(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public void createLessons(LessonDto lessonDto) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Calendar c = Calendar.getInstance();
        c.setTime(lessonDto.getSince());
        c.set(Calendar.DAY_OF_WEEK, lessonDto.getDayOfWeek());
        while (lessonDto.getTill().after(c.getTime())) {
            lessonDto.getUsers().forEach(user -> lessonRepository.save(new Lesson(c.getTime(), lessonDto.getCourse(), user)));
            c.add(Calendar.DAY_OF_MONTH, 7);
        }
    }

    @Override
    public void remove(Long lessonId) {
        lessonRepository.delete(lessonId);
    }

    private List<Long> getCourseId(User user) {
        if (user.getCourses() == null || user.getCourses().isEmpty()) {
            return Collections.singletonList(0L);
        } else {
            return user.getCourses().stream().map(Course::getId).collect(Collectors.toList());
        }
    }
}
