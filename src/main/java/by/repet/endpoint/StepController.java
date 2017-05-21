package by.repet.endpoint;//Created by vladr on 14.05.2017.

import by.repet.domain.Step;
import by.repet.services.StepService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/api/step")
public class StepController {

    private final StepService stepService;

    @GetMapping("/paragraph/{paragraphId}")
    public Collection<Step> getParagraphSteps(@PathVariable Long paragraphId) {
        return stepService.getAllByParagraphId(paragraphId);
    }

    @GetMapping("/course/{courseId}")
    public Collection<Step> getCourseSteps(@PathVariable Long courseId) {
        return stepService.getAllByCourseId(courseId);
    }

    @GetMapping("/count/course/{courseId}")
    public Integer getCourseStepsCount(@PathVariable Long courseId) {
        return stepService.getCourseStepsCount(courseId);
    }

    @GetMapping("/count/paragraph/{paragraphId}")
    public Integer getParagraphStepsCount(@PathVariable Long paragraphId) {
        return stepService.getParagraphStepsCount(paragraphId);
    }

    @GetMapping("/{stepId}")
    public Step getStep(@PathVariable Long stepId) {
        return stepService.getStep(stepId);
    }

    @PutMapping
    public Step saveStep(@RequestBody Step step) {
        return stepService.add(step);
    }

    @PostMapping
    public void saveAll(@RequestBody Collection<Step> steps) {
        stepService.saveAll(steps);
    }

    @DeleteMapping("/{stepId}")
    public ResponseEntity delete(@PathVariable Long stepId) {
        stepService.remove(stepId);
        return ResponseEntity.ok(stepId);
    }
}
