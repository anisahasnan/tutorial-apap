package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KamarServiceImpl implements KamarService{

    @Autowired
    KamarDb kamarDb;

    @Override
    public void addKamar(KamarModel kamar){
        kamarDb.save(kamar);
    }

    @Override
    public List<KamarModel> findAllKamarByIdHotel(Long idHotel){
        return kamarDb.findByHotelId(idHotel);
    }
}