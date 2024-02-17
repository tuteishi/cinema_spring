package by.cinema.cinema_web.repositories;

import by.cinema.cinema_web.dto.requests.TicketRequest;
import by.cinema.cinema_web.entities.Ticket;

import java.util.List;

public interface TicketRepositoryCustom {
    List<Ticket> getFreeTickets(Long filmId);

    void buyTicket(TicketRequest ticketRequest, Long userId);

    void returnTicket(TicketRequest ticketRequest);
}