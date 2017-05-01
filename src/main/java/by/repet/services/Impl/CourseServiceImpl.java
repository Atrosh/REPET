package by.repet.services.Impl;//Created by vladr on 20.12.2016.

import by.repet.domain.Course;
import by.repet.repositories.CourseRepository;
import by.repet.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@AllArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course getCourse(Long courseId) {
        return courseRepository.findOne(courseId);
    }

    @Override
    public Collection<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void remove(Long courseId) {
        courseRepository.delete(courseId);
    }
}
