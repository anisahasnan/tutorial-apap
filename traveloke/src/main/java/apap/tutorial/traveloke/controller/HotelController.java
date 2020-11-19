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

import java.util.List;

@Controller
public class HotelController{
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){

        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        if(hotel != null){
            model.addAttribute("hotel", hotel);
            return "form-update-hotel";
        }
        else{
            return "hotel-not-found";
        }

    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){

        if(hotel != null){
            HotelModel hotelUpdated = hotelService.updateHotel(hotel);
            model.addAttribute("hotel", hotel);
            return "update-hotel";
        }
        else{
            return "hotel-not-found";
        }
    }

    @GetMapping("/hotel/change")
    public String changeHotelnoId(){
        return "hotel-not-found";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value = "idHotel") Long idHotel,
            Model model){

        if(idHotel != null){
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            if (hotel != null) {
                List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
                boolean hasKamar = listKamar.size() > 0;
                model.addAttribute("hasKamar", hasKamar);
                model.addAttribute("hotel", hotel);
                model.addAttribute("listKamar", listKamar);
                return "view-hotel";
            }
            else{
                return "hotel-not-found";
            }
        }
        else{
            return "hotel-not-found";
        }
    }

    @GetMapping("/hotel/delete/{idHotel}")
    public String deleteHotel(
            @PathVariable Long idHotel,
            Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        if(hotel != null){
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
            boolean hasKamar = listKamar.size() > 0;
            if(!hasKamar){
                hotelService.deleteHotel(idHotel);
                model.addAttribute("hotel", hotel);
                return "delete-hotel";
            }
            else{
                return "no-room-hotel";
            }
        }
        else{
            return "hotel-not-found";
        }
    }

    @GetMapping("/hotel/delete")
    public String deleteHotelnoId(){
        return "hotel-not-found";
    }

    @GetMapping("/hotel/view-all")
    public String viewAllHotel(Model model){
        List<HotelModel> listHotel = hotelService.getAllHotel();
        model.addAttribute("listHotel", listHotel);
        return "view-all-hotel";
    }
}