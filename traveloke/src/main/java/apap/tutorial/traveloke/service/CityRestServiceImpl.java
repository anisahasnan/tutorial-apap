package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.rest.Setting;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class CityRestServiceImpl implements CityRestService{
    private final WebClient webClient;

    public CityRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.cityUrl).build();
    }

    public Mono<String> getHotelByCity(String city) {
        return this.webClient.get().uri("?query=" + city + "&locale=en_US").header("x-rapidapi-key", "77c769d001msh23d5b909b6f110cp1576d8jsn2c2c62fadc4c")
                .header("x-rapidapi-host", "hotels-com-free.p.rapidapi.com").retrieve().bodyToMono(String.class);
    }
}
