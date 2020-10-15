package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {
    void addKamar(KamarModel kamar);

    KamarModel getKamarByNoKamar(Long noKamar);

    KamarModel updateKamar(KamarModel kamar);

    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    void deleteKamar(KamarModel kamar);
}
