package by.cinema.cinema_web.mappers;

import by.cinema.cinema_web.dto.requests.CreateTicketRequest;
import by.cinema.cinema_web.dto.responses.TicketResponse;
import by.cinema.cinema_web.entities.Ticket;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TicketMapper {
    Ticket ticketRequestToTicket(CreateTicketRequest ticketRequest);

    TicketResponse ticketToTicketResponse(Ticket ticket);

    List<TicketResponse> ticketListToTicketResponseList(List<Ticket> tickets);

}