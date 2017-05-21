package by.repet.domain;//Created by vladr on 23.04.2017.

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "progresses")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private boolean passed;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Step step;

}
