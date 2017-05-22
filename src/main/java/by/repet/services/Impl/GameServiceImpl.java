package by.repet.services.Impl;//Created by vladr on 22.05.2017.

import by.repet.domain.Game;
import by.repet.repositories.GameRepository;
import by.repet.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public Game get(Long gameId) {
        return gameRepository.findOne(gameId);
    }

    @Override
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> getNearest() {
        return gameRepository.findTop10ByOrderByDate();
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void remove(Long id) {
        gameRepository.delete(id);
    }
}
