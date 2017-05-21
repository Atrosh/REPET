package by.repet.endpoint;//Created by vladr on 20.12.2016.

import by.repet.common.LessonDto;
import by.repet.domain.Lesson;
import by.repet.services.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/api/lesson")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/today")
    public Collection<Lesson> getToday() {
        return lessonService.getTodayLessons();
    }

    @GetMapping("/week")
    public ArrayList<Collection<Lesson>> getWeek() {
        return lessonService.getWeekLessons();
    }

    @PostMapping
    public ResponseEntity createLessons(@RequestBody LessonDto lessonDto) {
        lessonService.createLessons(lessonDto);
        return ResponseEntity.ok().build();
    }

}
