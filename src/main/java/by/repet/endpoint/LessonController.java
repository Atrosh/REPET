package by.repet.endpoint;//Created by vladr on 20.12.2016.

import by.repet.domain.Lesson;
import by.repet.services.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@AllArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/api/lessons")
    public Collection<Lesson> getToday() {
        return lessonService.getTodayLessons();
    }

    @GetMapping("/api/week")
    public ArrayList<Collection<Lesson>> getWeek() {
        return lessonService.getWeekLessons();
    }

}
