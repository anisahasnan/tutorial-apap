package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.service.CityRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class CityRestController {
    @Autowired
    private CityRestService cityRestService;

    @GetMapping("/hotel/find")
    public Mono<String> searchHotelByCity(@RequestParam(value = "cityName") String cityName){
        return cityRestService.getHotelByCity(cityName);
    }
}
