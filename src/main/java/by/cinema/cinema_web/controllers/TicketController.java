package by.cinema.cinema_web.controllers;

import by.cinema.cinema_web.dto.requests.CreateTicketRequest;
import by.cinema.cinema_web.dto.responses.SailTicketResponse;
import by.cinema.cinema_web.dto.responses.TicketResponse;
import by.cinema.cinema_web.services.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("buyTicket/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public SailTicketResponse buyTicket(@PathVariable Long userId,
                                        @RequestBody @Valid CreateTicketRequest ticketRequest) {
        return ticketService.buyTicket(ticketRequest, userId);
    }

    @PostMapping("returnTicket")
    @ResponseStatus(HttpStatus.OK)
    public SailTicketResponse returnTicket(@RequestBody @Valid CreateTicketRequest ticketRequest) {
        return ticketService.returnTicket(ticketRequest);
    }

    @GetMapping("ticket/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TicketResponse getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping("freeTickets/{filmId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TicketResponse> getFreeTickets(@PathVariable Long filmId) {
        return ticketService.getFreeTickets(filmId);
    }

    @GetMapping("userTickets/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TicketResponse> getUserTickets(@PathVariable Long userId) {
        return ticketService.getUserTickets(userId);
    }

    @GetMapping("allTickets")
    @ResponseStatus(HttpStatus.OK)
    public List<TicketResponse> getAllTickets() {
        return ticketService.getAllTickets();
    }
}