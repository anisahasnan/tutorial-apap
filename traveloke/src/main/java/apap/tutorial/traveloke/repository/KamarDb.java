package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KamarDb extends JpaRepository<KamarModel,Long>{
    List<KamarModel> findByHotelId(Long hotelId);

    KamarModel findByNamaKamarAndKapasitasKamar(String name, Integer capacity);
}
