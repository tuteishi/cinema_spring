package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.CreateTicketRequest;
import by.cinema.cinema_web.dto.responses.SailTicketResponse;
import by.cinema.cinema_web.dto.responses.TicketResponse;
import by.cinema.cinema_web.entities.Film;

import java.util.List;

public interface TicketService {

    void createTikets(Film film);

    TicketResponse getTicketById(Long ticketId);

    List<TicketResponse> getAllTickets();

    List<TicketResponse> getFreeTickets(Long filmId);

    List<TicketResponse> getUserTickets(Long userId);

    SailTicketResponse buyTicket(CreateTicketRequest ticketRequest, Long userId);

    SailTicketResponse returnTicket(CreateTicketRequest ticketRequest);
}