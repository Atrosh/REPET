package by.repet.services.Impl;//Created by vladr on 23.05.2017.

import by.repet.domain.Game;
import by.repet.domain.Ticket;
import by.repet.domain.User;
import by.repet.repositories.GameRepository;
import by.repet.repositories.TicketRepository;
import by.repet.repositories.UserRepository;
import by.repet.services.TicketService;
import by.repet.services.UserContextService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private static final BigDecimal TICKET_PRICE = BigDecimal.ONE;

    private final GameRepository gameRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final UserContextService userContextService;

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getByGameId(Long gameId) {
        return ticketRepository.findAllByGameId(gameId);
    }

    @Override
    public List<Ticket> getByUserId(Long userId) {
        return ticketRepository.findAllByOwnerId(userId);
    }

    @Override
    public List<Ticket> getByCurrentUser() {
        User user = userContextService.getCurrentUser();
        return ticketRepository.findAllByOwnerId(user.getId());
    }

    @Override
    public Ticket save(Ticket ticket) {
        ticket.setOwner(userContextService.getCurrentUser());
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket buy(Long gameId) {
        Game game = gameRepository.findOne(gameId);
        if (game != null) {
            User user = userContextService.getCurrentUser();
            BigDecimal userMoney = user.getMoney();
            if (userMoney.compareTo(TICKET_PRICE) > 0) {
                user.setMoney(user.getMoney().subtract(TICKET_PRICE));
                userRepository.save(user);
                return ticketRepository.save(new Ticket(null, user, game, null));
            }
        }
        return null;
    }

    @Override
    public void remove(Long ticketId) {
        ticketRepository.delete(ticketId);
    }
}
