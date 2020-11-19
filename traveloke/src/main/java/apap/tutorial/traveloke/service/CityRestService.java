package apap.tutorial.traveloke.service;

import reactor.core.publisher.Mono;

public interface CityRestService {
    Mono<String> getHotelByCity(String city);
}
