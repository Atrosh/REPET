package by.repet.endpoint;//Created by vladr on 13.05.2017.

import by.repet.domain.Paragraph;
import by.repet.services.ParagraphService;
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

@RestController
@AllArgsConstructor
@RequestMapping("/api/paragraph")
public class ParagraphController {

    private final ParagraphService paragraphService;

    @GetMapping("unit/{unitId}")
    public Collection<Paragraph> getUnitParagraphs(@PathVariable Long unitId) {
        return paragraphService.getAllByUnitId(unitId);
    }

    @GetMapping("/{paragraphId}")
    public Paragraph getParagraph(@PathVariable Long paragraphId) {
        return paragraphService.getParagraph(paragraphId);
    }

    @PutMapping
    public Paragraph saveParagraph(@RequestBody Paragraph paragraph) {
        return paragraphService.add(paragraph);
    }

    @PostMapping
    public void saveAll(@RequestBody Collection<Paragraph> paragraphs) {
        paragraphService.saveAll(paragraphs);
    }

    @DeleteMapping("/{paragraphId}")
    public ResponseEntity delete(@PathVariable Long paragraphId) {
        paragraphService.remove(paragraphId);
        return ResponseEntity.ok(paragraphId);
    }

}
