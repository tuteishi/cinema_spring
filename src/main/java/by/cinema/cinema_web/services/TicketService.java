package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.TicketRequest;
import by.cinema.cinema_web.dto.responses.SailTicketResponse;
import by.cinema.cinema_web.dto.responses.TicketResponse;
import by.cinema.cinema_web.entities.Film;

import java.util.List;

public interface TicketService {

    /** Making a tickets for film. */
    void createTickets(Film film);

    /** Getting a ticket by id. */
    TicketResponse getTicketById(Long ticketId);

    /** Getting all tickets. */
    List<TicketResponse> getTickets();

    /** Getting free tickets. */
    List<TicketResponse> getFreeTickets(Long filmId);

    /** Getting user tickets. */
    List<TicketResponse> getUserTickets(Long userId);

    /** Buying ticket. */
    SailTicketResponse buyTicket(TicketRequest ticketRequest, Long userId);

    /** Return of ticket. */
    SailTicketResponse returnTicket(TicketRequest ticketRequest);
}