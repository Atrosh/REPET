package by.repet.endpoint;//Created by vladr on 20.05.2017.

import by.repet.domain.Progress;
import by.repet.services.ProgressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("api/progress")
public class ProgressController {

    private final ProgressService progressService;

    @GetMapping("/course/{courseId}")
    public Collection<Progress> getByCourse(@PathVariable Long courseId) {
        return progressService.findByCourseId(courseId);
    }

    @GetMapping("/{id}")
    public Progress getProgress(@PathVariable Long id) {
        return progressService.findOne(id);
    }

    @GetMapping("/count/course/{courseId}")
    public Integer getCourseStepsCount(@PathVariable Long courseId) {
        return progressService.getCountByCourseId(courseId);
    }

    @PostMapping
    public Progress saveProgress(@RequestBody Progress progress) {
        return progressService.save(progress);
    }

}
