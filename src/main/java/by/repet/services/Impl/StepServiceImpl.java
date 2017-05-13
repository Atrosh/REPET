package by.repet.services.Impl;//Created by vladr on 14.05.2017.

import by.repet.domain.Step;
import by.repet.repositories.StepRepository;
import by.repet.services.StepService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class StepServiceImpl implements StepService {

    private final StepRepository stepRepository;

    @Override
    public Step getStep(Long stepId) {
        return stepRepository.findOne(stepId);
    }

    @Override
    public Collection<Step> getAll() {
        return stepRepository.findAll();
    }

    @Override
    public Collection<Step> getAllByParagraphId(Long paragraphId) {
        return stepRepository.getAllByParagraphId(paragraphId);
    }

    @Override
    public Step add(Step step) {
        return stepRepository.save(step);
    }

    @Override
    public void remove(Long stepId) {
        stepRepository.delete(stepId);
    }

    @Override
    public void saveAll(Collection<Step> steps) {
        stepRepository.save(steps);
    }
}
