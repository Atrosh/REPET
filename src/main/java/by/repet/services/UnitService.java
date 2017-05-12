package by.repet.services;


import by.repet.domain.Unit;

import java.util.Collection;

/**
 * Created by v.atroshkin on 12.05.2017.
 */
public interface UnitService {
    Unit getUnit(Long unitId);

    Collection<Unit> getAll();

    Collection<Unit> getAllByCourseId(Long courseId);

    Unit add(Unit unit);

    void remove(Long unitId);

    void saveAll(Collection<Unit> units);
}
