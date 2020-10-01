package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelInMemoryService implements HotelService{

    private List<HotelModel> listHotel;

    // Constructor
    public HotelInMemoryService(){
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel){
        listHotel.add(hotel);
    }

    public void deleteHotel(String idHotel){
        for(HotelModel hotel : listHotel) {
            if (hotel.getIdHotel().equals(idHotel)) {
                listHotel.remove(hotel);
                return ;
            }
        }
    }

    @Override
    public List<HotelModel> getHotelList(){
        return listHotel;
    }

    @Override
    public HotelModel getHotelByIdHotel(String idHotel){
        for(HotelModel hotel : listHotel){
            if(hotel.getIdHotel().equals(idHotel)){
                return hotel;
            }
        }
        return null;
    }
}
