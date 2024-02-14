package by.cinema.cinema_web.dto.responses.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}