package by.repet.repositories;//Created by vladr on 30.04.2017.

import by.repet.domain.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {
    Collection<Paragraph> findAllByUnitId(long unitId);
}
