package by.repet.services.Impl;//Created by vladr on 20.12.2016.

import by.repet.domain.Lesson;
import by.repet.repositories.LessonRepository;
import by.repet.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Lesson getLesson(Long lessonId) {
        return lessonRepository.findOne(lessonId);
    }

    @Override
    public Collection<Lesson> getAll() {
        return lessonRepository.findAll();
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
