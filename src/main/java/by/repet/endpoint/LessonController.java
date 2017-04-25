package by.repet.endpoint;//Created by vladr on 20.12.2016.

import by.repet.domain.Lesson;
import by.repet.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/api/lessons")
    @ResponseBody
    public Collection<Lesson> getToday() {
        return lessonService.getTodayLessons();
    }

    @GetMapping("/api/week")
    @ResponseBody
    public ArrayList<Collection<Lesson>> getWeek() {
        return lessonService.getWeekLessons();
    }

}
