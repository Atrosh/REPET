package by.repet.endpoint;//Created by vladr on 23.05.2017.

import by.repet.domain.Ticket;
import by.repet.services.TicketService;
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
@RequestMapping("api/ticket")
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    public List<Ticket> getMy() {
        return ticketService.getByCurrentUser();
    }

    @GetMapping("/user/{userId}")
    public List<Ticket> getUserTickets(@PathVariable Long userId) {
        return ticketService.getByUserId(userId);
    }

    @GetMapping("/game/{gameId}")
    public List<Ticket> getGameTickets(@PathVariable Long gameId) {
        return ticketService.getByGameId(gameId);
    }

    @PostMapping
    public Ticket save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @PostMapping("/buy/{gameId}")
    public ResponseEntity buy(@PathVariable Long gameId) {
        Ticket ticket = ticketService.buy(gameId);
        return ticket == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(ticket);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity delete(@PathVariable Long ticketId) {
        ticketService.remove(ticketId);
        return ResponseEntity.ok().build();
    }

}
