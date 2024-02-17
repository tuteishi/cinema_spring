package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.TicketRequest;
import by.cinema.cinema_web.dto.responses.SailTicketResponse;
import by.cinema.cinema_web.dto.responses.TicketResponse;
import by.cinema.cinema_web.entities.Film;

import java.util.List;

public interface TicketService {

    void createTickets(Film film);

    TicketResponse getTicketById(Long ticketId);

    List<TicketResponse> getTickets();

    List<TicketResponse> getFreeTickets(Long filmId);

    List<TicketResponse> getUserTickets(Long userId);

    SailTicketResponse buyTicket(TicketRequest ticketRequest, Long userId);

    SailTicketResponse returnTicket(TicketRequest ticketRequest);
}