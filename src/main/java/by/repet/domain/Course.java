package by.repet.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//Created by vladr on 20.11.2016.
@Entity
@Table(name = "courses")
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private long id;

    @JsonProperty
    private String name;

    @OneToMany(mappedBy = "course", cascade = {CascadeType.REMOVE})
    private Set<Lesson> lessons;
}
