package by.repet.repositories;//Created by vladr on 22.05.2017.

import by.repet.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findTop10ByOrderByDate();
}
