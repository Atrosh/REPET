package by.repet.services;//Created by vladr on 22.05.2017.

import by.repet.domain.Game;

import java.util.List;

public interface GameService {
    Game get(Long gameId);

    List<Game> getAll();

    List<Game> getNearest();

    Game save(Game game);

    void remove(Long id);
}
