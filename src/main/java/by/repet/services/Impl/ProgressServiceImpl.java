package by.repet.services.Impl;//Created by vladr on 20.05.2017.

import by.repet.domain.Progress;
import by.repet.repositories.ProgressRepository;
import by.repet.services.ProgressService;
import by.repet.services.UserContextService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepository;
    private final UserContextService userContextService;

    @Override
    public Progress findOne(Long id) {
        return progressRepository.findOne(id);
    }

    @Override
    public Progress save(Progress progress) {
        progress.setUser(userContextService.getCurrentUser());
        return progressRepository.save(progress);
    }

    @Override
    public void remove(Long id) {
        progressRepository.delete(id);
    }

    @Override
    public Collection<Progress> findByCourseId(Long courseId) {
        return progressRepository.findAllByUserIdAndStepParagraphUnitCourseId(userContextService.getCurrentUser().getId(), courseId);
    }

    @Override
    public Integer getCountByCourseId(Long courseId) {
        return progressRepository.countAllByUserIdAndStepParagraphUnitCourseId(userContextService.getCurrentUser().getId(), courseId);
    }

}
