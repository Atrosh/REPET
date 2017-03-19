package by.repet.services;//Created by vladr on 20.12.2016.

import by.repet.domain.Course;

import java.util.Collection;

public interface CourseService {
    Course getCourse(Long courseId);

    Collection<Course> getAll();

    void add(Course course);

    void remove(Long courseId);
}
