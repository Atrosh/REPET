package by.repet.services.Impl;//Created by vladr on 13.05.2017.

import by.repet.domain.Paragraph;
import by.repet.repositories.ParagraphRepository;
import by.repet.services.ParagraphService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ParagraphServiceImpl implements ParagraphService {

    private final ParagraphRepository paragraphRepository;

    @Override
    public Paragraph getParagraph(Long paragraphId) {
        return paragraphRepository.findOne(paragraphId);
    }

    @Override
    public Collection<Paragraph> getAll() {
        return paragraphRepository.findAll();
    }

    @Override
    public Collection<Paragraph> getAllByUnitId(Long unitId) {
        return paragraphRepository.findAllByUnitId(unitId);
    }

    @Override
    public Paragraph add(Paragraph paragraph) {
        return paragraphRepository.save(paragraph);
    }

    @Override
    public void remove(Long paragraphId) {
        paragraphRepository.delete(paragraphId);
    }

    @Override
    public void saveAll(Collection<Paragraph> paragraphs) {
        paragraphRepository.save(paragraphs);
    }
}
