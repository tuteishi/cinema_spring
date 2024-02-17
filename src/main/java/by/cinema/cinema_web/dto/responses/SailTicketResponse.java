package by.cinema.cinema_web.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SailTicketResponse {

    private Long ticketId;

    private boolean isSail;
}