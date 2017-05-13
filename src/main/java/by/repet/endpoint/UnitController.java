package by.repet.endpoint;

import by.repet.domain.Unit;
import by.repet.services.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by v.atroshkin on 12.05.2017.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/unit")
public class UnitController {
    private final UnitService unitService;

    @GetMapping("course/{courseId}")
    public Collection<Unit> getCourseUnits(@PathVariable Long courseId) {
        return unitService.getAllByCourseId(courseId);
    }

    @GetMapping("/{unitId}")
    public Unit getUnit(@PathVariable Long unitId) {
        return unitService.getUnit(unitId);
    }

    @PutMapping
    public Unit saveUnit(@RequestBody Unit unit) {
        return unitService.add(unit);
    }

    @PostMapping
    public void saveAll(@RequestBody Collection<Unit> units) {
        unitService.saveAll(units);
    }

    @DeleteMapping("/{unitId}")
    public ResponseEntity delete(@PathVariable Long unitId) {
        unitService.remove(unitId);
        return ResponseEntity.ok(unitId);
    }
}
