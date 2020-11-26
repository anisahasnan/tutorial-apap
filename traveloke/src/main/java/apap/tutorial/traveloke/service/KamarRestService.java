package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;
//import apap.tutorial.traveloke.rest.KamarDetail;

import java.util.List;

public interface KamarRestService {
    KamarModel createKamar(KamarModel kamar);

    List<KamarModel> retrieveListKamar();

    KamarModel getKamarByNoKamar(Long kamarId);

    KamarModel changeKamar(Long kamarId, KamarModel kamarUpdate);

    void deleteKamar(Long kamarId);
}
