package by.repet.repositories;//Created by vladr on 20.12.2016.

import by.repet.domain.Course;
import by.repet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>{
    Collection<Course> findAllByOwnersContaining(List<User> owners);
    Collection<Course> findAllByOrganisationId(long organisationId);
}
