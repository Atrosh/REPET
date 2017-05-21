package by.repet.common;//Created by vladr on 21.05.2017.

import by.repet.domain.Course;
import by.repet.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LessonDto {
    private Collection<User> users;
    private Date since;
    private Date till;
    private Course course;
    private int dayOfWeek;
}
