package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.rest.HotelDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface HotelRestService {
    HotelModel createHotel(HotelModel hotel);

    List<HotelModel> retrieveListHotel();

    HotelModel getHotelByIdHotel(Long idHotel);

    HotelModel changeHotel(Long idHotel, HotelModel hotelUpdate);

    void deleteHotel(Long idHotel);

    Mono<String> getStatus(Long idHotel);

    Mono<HotelDetail> postStatus();
}
