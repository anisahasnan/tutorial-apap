package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import java.util.List;

public interface HotelService {
    // Method menambah hotel
    void addHotel(HotelModel hotel);

    // Method mendapatkan daftar hotel yang tersimpan
    List<HotelModel> getHotelList();

    // Method mendapatkan data sebuah hotel beradasrkan id
    HotelModel getHotelByIdHotel(Long idHotel);

    //Method untuk update hotel
    HotelModel updateHotel(HotelModel hotel);

    void deleteHotel(Long idHotel);

    List<HotelModel> getAllHotel();

}
