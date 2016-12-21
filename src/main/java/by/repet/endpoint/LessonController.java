package by.repet.endpoint;//Created by vladr on 20.12.2016.

import by.repet.domain.Lesson;
import by.repet.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping(value="/api/lessons", method= RequestMethod.GET)
    public @ResponseBody Collection<Lesson> getAll() {
        return lessonService.getAll();
    }
}
