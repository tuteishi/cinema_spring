package by.cinema.cinema_web.feingClients;

import by.cinema.cinema_web.dto.responses.api.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "reqres-client", url = "${services.external.reqres.url}")
public interface ReqresClient {
    @GetMapping
    Root getApiUser();
}