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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        if(hotel != null){
            List<KamarModel> listKamar = hotel.getListKamar();
            listKamar.clear();

            KamarModel kamar = new KamarModel();
            listKamar.add(kamar);

            model.addAttribute("hotel", hotel);
            model.addAttribute("listKamar", listKamar);

            return "form-add-kamar";
        }
        else{
            return "hotel-not-found";
        }
    }

    @PostMapping(value="/kamar/add", params={"addRow"})
    public String kamarAddRow(
            @ModelAttribute HotelModel hotel,
            Model model)
    {
        List<KamarModel> listKamar = hotel.getListKamar();

        KamarModel kamar = new KamarModel();
        listKamar.add(kamar);

        model.addAttribute("hotel", hotel);
        model.addAttribute("listKamar", listKamar);

        return "form-add-kamar";
    }

    @PostMapping(value="/kamar/add", params={"deleteRow"})
    public String kamarDeleteRow(
            @ModelAttribute HotelModel hotel,
            HttpServletRequest request,
            Model model)
    {
        int rowNum = Integer.valueOf(request.getParameter("deleteRow"));

        List<KamarModel> listKamar = hotel.getListKamar();
        listKamar.remove(rowNum);

        model.addAttribute("hotel", hotel);
        model.addAttribute("listKamar", listKamar);

        return "form-add-kamar";
    }

    @PostMapping(value="/kamar/add", params={"simpan"})
    private String addKamarSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){

            model.addAttribute("kamarCount", hotel.getListKamar().size());

            for(KamarModel kamar : hotel.getListKamar()){
                kamar.setHotel(hotel);
                kamarService.addKamar(kamar);
            }

            return "add-kamar";
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

//    @GetMapping("/kamar/delete/{noKamar}")
//    public String deleteKamar(
//            @PathVariable Long noKamar,
//            Model model){
//        KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
//        if(kamar != null){
//            kamarService.deleteKamar(noKamar);
//            model.addAttribute("kamar", kamar);
//            return "delete-kamar";
//        }
//        else{
//            return "kamar-not-found";
//        }
//    }

    @PostMapping(path="/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount", hotel.getListKamar().size());

        for(KamarModel kamar : hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }

        return "delete-kamar";
    }

//        List<KamarModel> tempList = new ArrayList<>();
//        model.addAttribute("tempList", hotel.getListKamar().size());
////
////        model.addAttribute("tempList", tempList);
////
//        return "form-add-kamar";
//    }
}