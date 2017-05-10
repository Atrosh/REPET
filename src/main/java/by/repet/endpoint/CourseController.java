package by.repet.endpoint;//Created by vladr on 02.05.2017.

import by.repet.domain.Course;
import by.repet.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public Course createNewCourse(@RequestBody Course course) {
        return courseService.add(course);
    }

    @GetMapping
    public Collection<Course> getAll() {
        return courseService.getAll();
    }
}