package by.cinema.cinema_web.repositories;

import by.cinema.cinema_web.dto.requests.CreateTicketRequest;

public interface TicketRepositoryCustom {
    Long buyTicket(CreateTicketRequest ticketRequest, Long userId);
    Long returnTicket(CreateTicketRequest ticketRequest);
}