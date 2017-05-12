package by.repet.services.Impl;

import by.repet.domain.Unit;
import by.repet.repositories.UnitRepository;
import by.repet.services.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by v.atroshkin on 12.05.2017.
 */
@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;


    @Override
    public Unit getUnit(Long unitId) {
        return unitRepository.findOne(unitId);
    }

    @Override
    public Collection<Unit> getAll() {
        return unitRepository.findAll();
    }

    @Override
    public Collection<Unit> getAllByCourseId(Long courseId) {
        return unitRepository.getAllByCourseId(courseId);
    }

    @Override
    public Unit add(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public void remove(Long unitId) {
        unitRepository.delete(unitId);
    }

    @Override
    public void saveAll(Collection<Unit> units) {
        unitRepository.save(units);
    }
}
