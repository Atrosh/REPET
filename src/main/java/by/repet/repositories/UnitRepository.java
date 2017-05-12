package by.repet.repositories;//Created by vladr on 30.04.2017.

import by.repet.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import java.util.Collection;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    Collection<Unit> getAllByCourseId(Long courseId);
}
