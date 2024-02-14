package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.CreateTicketRequest;
import by.cinema.cinema_web.dto.responses.SailTicketResponse;
import by.cinema.cinema_web.dto.responses.TicketResponse;
import by.cinema.cinema_web.entities.Film;
import by.cinema.cinema_web.entities.Ticket;
import by.cinema.cinema_web.exceptions.TicketNotFoundException;
import by.cinema.cinema_web.mappers.CreateTicketMapper;
import by.cinema.cinema_web.mappers.TicketMapper;
import by.cinema.cinema_web.repositories.TicketRepository;
import by.cinema.cinema_web.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final CreateTicketMapper createTicketMapper;
    private final TicketMapper ticketMapper;

    @Override
    @Transactional
    public void createTikets(Film film) {
        for (int count = 1; count <= 10; count++) {
            ticketRepository.save(createTicketMapper.CreateNewTicket(film, count));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public TicketResponse getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).
                orElseThrow(() -> new TicketNotFoundException(ticketId.toString()));
        return ticketMapper.ticketToTicketResponse(ticket);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketResponse> getAllTickets() {
        List<Ticket> allTickets = ticketRepository.findAll();
        return ticketMapper.ticketListToTicketResponseList(allTickets);
    }

    @Override
    @Transactional
    public List<TicketResponse> getFreeTickets(Long filmId) {
        List<Ticket> freeTickets = ticketRepository.getFreeTicketsByFilmId(filmId);
        return ticketMapper.ticketListToTicketResponseList(freeTickets);
    }

    @Override
    @Transactional
    public List<TicketResponse> getUserTickets(Long userId) {
        List<Ticket> userTickets = ticketRepository.getUserTickets(userId);
        return ticketMapper.ticketListToTicketResponseList(userTickets);
    }

    @Override
    @Transactional
    public SailTicketResponse buyTicket(CreateTicketRequest ticketRequest, Long userId) {
        ticketRepository.buyTicket(ticketRequest, userId);
        SailTicketResponse ticketResponse = SailTicketResponse.builder().
                ticketId(ticketRequest.getTicketId())
                .sail(true)
                .build();
        return ticketResponse;
    }

    @Override
    @Transactional
    public SailTicketResponse returnTicket(CreateTicketRequest ticketRequest) {
        ticketRepository.returnTicket(ticketRequest);
        SailTicketResponse ticketResponse = SailTicketResponse.builder().
                ticketId(ticketRequest.getTicketId())
                .sail(false)
                .build();
        return ticketResponse;
    }
}