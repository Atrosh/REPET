package by.repet.repositories;//Created by vladr on 22.05.2017.

import by.repet.domain.Prize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrizeRepository extends JpaRepository<Prize, Long> {
    List<Prize> findAllByTicketOwnerId(Long ownerId);
    List<Prize> findAllByTicketGameId(Long gameId);
}
