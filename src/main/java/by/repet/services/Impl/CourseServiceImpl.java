package by.repet.services.Impl;//Created by vladr on 20.12.2016.

import by.repet.domain.Course;
import by.repet.repositories.CourseRepository;
import by.repet.services.CourseService;
import by.repet.services.UserContextService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;

@Service
@AllArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserContextService userContextService;

    @Override
    public Course getCourse(Long courseId) {
        return courseRepository.findOne(courseId);
    }

    @Override
    public Collection<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Collection<Course> getAllByUser() {
        return courseRepository.findAllByOrganisationId(userContextService.getCurrentUser().getOrganisation().getId());
    }

    @Override
    public Collection<Course> getCurrentTeacherCourses() {
        return userContextService.getCurrentUser().getCourses();
    }

    @Override
    public Collection<Course> getAllByOrganisationId(Long organisationId) {
        return courseRepository.findAllByOrganisationId(organisationId);
    }

    @Override
    public Course add(Course course) {
        course.setOwners(Collections.singletonList(userContextService.getCurrentUser()));
        return courseRepository.save(course);
    }

    @Override
    public void remove(Long courseId) {
        courseRepository.delete(courseId);
    }
}
