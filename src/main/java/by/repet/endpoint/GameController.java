package by.repet.endpoint;//Created by vladr on 23.05.2017.

import by.repet.domain.Game;
import by.repet.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/game")
public class GameController {

    private final GameService gameService;

    @GetMapping("/all")
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @GetMapping("/nearest")
    public List<Game> getNearest() {
        return gameService.getNearest();
    }

    @PostMapping
    public Game save(@RequestBody Game game) {
        return gameService.save(game);
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity delete(@PathVariable Long gameId) {
        gameService.remove(gameId);
        return ResponseEntity.ok().build();
    }

}
