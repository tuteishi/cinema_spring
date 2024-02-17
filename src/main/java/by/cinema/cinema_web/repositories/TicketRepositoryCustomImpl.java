package by.cinema.cinema_web.repositories;

import by.cinema.cinema_web.dto.requests.TicketRequest;
import by.cinema.cinema_web.entities.Ticket;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static by.cinema.cinema_web.entities.QTicket.ticket;

public class TicketRepositoryCustomImpl extends QuerydslRepositorySupport
        implements TicketRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public TicketRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Ticket.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Ticket> getFreeTickets(Long filmId) {
        return jpaQueryFactory.select(ticket)
                .where(ticket.film.filmId.eq(filmId))
                .where(ticket.isSail.eq(false))
                .fetch();
    }

    @Override
    public void buyTicket(TicketRequest ticketRequest, Long userId) {
        jpaQueryFactory.update(ticket)
                .where(ticket.ticketId.eq(ticketRequest.getTicketId()))
                .set(ticket.isSail, true)
                .set(ticket.user.userId, userId)
                .execute();
    }

    @Override
    public void returnTicket(TicketRequest ticketRequest) {
        jpaQueryFactory.update(ticket)
                .where(ticket.ticketId.eq(ticketRequest.getTicketId()))
                .set(ticket.isSail, false)
                .set(ticket.user.userId, (Long) null)
                .execute();
    }
}