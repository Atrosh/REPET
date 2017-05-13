package by.repet.services;//Created by vladr on 13.05.2017.

import by.repet.domain.Paragraph;

import java.util.Collection;

public interface ParagraphService {
    Paragraph getParagraph(Long paragraphId);

    Collection<Paragraph> getAll();

    Collection<Paragraph> getAllByUnitId(Long unitId);

    Paragraph add(Paragraph paragraph);

    void remove(Long paragraphId);

    void saveAll(Collection<Paragraph> paragraphs);
}
