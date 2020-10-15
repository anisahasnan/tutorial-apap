package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KamarController{
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model){
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel != null){
            kamar.setHotel(hotel);
            model.addAttribute("kamar", kamar);
            return "form-add-kamar";
        }
        else{
            return "hotel-not-found";
        }
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model){
        if(kamar != null){
            kamarService.addKamar(kamar);
            model.addAttribute("kamar", kamar);
            return "add-kamar";
        }
        else{
            return "hotel-not-found";
        }
    }

    @GetMapping("/kamar/add")
    private String addKamarnoIdHotel(){
        return "hotel-not-found";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarFormPage(
            @PathVariable Long noKamar,
            Model model){
        KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
        if(kamar != null){
            model.addAttribute("kamar", kamar);
            return "form-update-kamar";
        }
        else{
            return "kamar-not-found";
        }
    }

    @PostMapping("/kamar/change")
    public String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model){

        if(kamar != null){
            KamarModel kamarUpdated = kamarService.updateKamar(kamar);
            model.addAttribute("kamar", kamar);
            return "update-kamar";
        }
        else{
            return "kamar-not-found";
        }
    }

    @GetMapping("/kamar/change")
    public String changeKamarnoId(){
        return "kamar-not-found";
    }

    @GetMapping("/kamar/delete/{noKamar}")
    public String deleteKamar(
            @PathVariable Long noKamar,
            Model model){
        KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
        if(kamar != null){
            kamarService.deleteKamar(noKamar);
            model.addAttribute("kamar", kamar);
            return "delete-kamar";
        }
        else{
            return "kamar-not-found";
        }
    }

    @GetMapping("/kamar/delete")
    public String deleteKamarnoId(){
        return "kamar-not-found";
    }
}