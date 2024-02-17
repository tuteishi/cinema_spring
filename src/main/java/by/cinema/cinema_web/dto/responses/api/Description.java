package by.cinema.cinema_web.dto.responses.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Description {

    private int id;

    private String title;

    private String body;

    private int userId;

    private List<String> tags;

    private int reactions;
}
