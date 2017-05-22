package by.repet.repositories;//Created by vladr on 22.05.2017.

import by.repet.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByGameId(Long gameId);
    List<Ticket> findAllByOwnerId(Long ownerId);
}
