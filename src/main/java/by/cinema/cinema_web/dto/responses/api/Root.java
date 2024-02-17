package by.cinema.cinema_web.dto.responses.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Root {

    public List<Description> posts;

    public int total;

    public int skip;

    public int limit;
}