package by.repet.services.Impl;//Created by vladr on 20.12.2016.

import by.repet.domain.Course;
import by.repet.repositories.CourseRepository;
import by.repet.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course getCourse(Long courseId) {
        return courseRepository.findOne(courseId);
    }

    @Override
    public Collection<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public void add(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void remove(Long courseId) {
        courseRepository.delete(courseId);
    }
}
