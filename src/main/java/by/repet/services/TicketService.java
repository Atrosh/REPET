package by.repet.services;//Created by vladr on 22.05.2017.

import by.repet.domain.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAll();

    List<Ticket> getByGameId(Long gameId);

    List<Ticket> getByUserId(Long userId);

    List<Ticket> getByCurrentUser();

    Ticket save(Ticket ticket);

    Ticket buy(Long gameId);

    void remove(Long ticketId);

}
