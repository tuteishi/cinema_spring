package by.cinema.cinema_web.feingClients;

import by.cinema.cinema_web.dto.responses.api.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "description-client", url = "${services.external.dummy.url}")
public interface DescriptionClient {

    @GetMapping
    Root getDescription();
}