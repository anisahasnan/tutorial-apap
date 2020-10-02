package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    // Routing URL
    @RequestMapping("/hotel/add")
    public String addHotel(
            // Request param yg ingin dibawa
            @RequestParam(value= "idHotel", required = true) String idHotel,
            @RequestParam(value= "namaHotel", required = true) String namaHotel,
            @RequestParam(value= "alamat", required = true) String alamat,
            @RequestParam(value= "noTelepon", required = true) String noTelepon,
            Model model
    ){

        // Membuat objek HotelModel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        // Memanggil service addHotel
        hotelService.addHotel(hotel);

        // Add variable id hotel ke 'idhotel' untuk dirender pada thymeleaf
        model.addAttribute("idHotel", idHotel);

        // Return view template yang digunakan
        return "add-hotel";
    }

    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){

        // Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

        // Add variable semua HotelModel ke 'listHotel' untuk dirender pada thymeleaf
        model.addAttribute("listHotel", listHotel);

        // Return view ke template yg diinginkan
        return "viewall-hotel";
    }

    @RequestMapping("/hotel/view")
    public String detailHotel(
            @RequestParam(value= "idHotel") String idHotel,
            Model model){

        // Mendapatkan HotelModel sesuai dgn idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        if(hotel != null) {
            // Add variable HotelModel ke 'hotel' untuk dirender pada thymeleaf
            model.addAttribute("hotel", hotel);

            return "view-hotel";
        }
        else{
            return "error-page";
        }
    }

    @GetMapping(value = "/hotel/view/id-hotel/{idHotel}")
    public String detailHotelGet(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ){
        // Mendapatkan HotelModel sesuai dgn idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        if(hotel != null) {
            // Add variable HotelModel ke 'hotel' untuk dirender pada thymeleaf
            model.addAttribute("hotel", hotel);

            return "view-hotel";
        }
        else{
            return "error-page";
        }
    }

    @GetMapping(value = "/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
    public String updateHotel(
            @PathVariable(value = "idHotel") String idHotel,
            @PathVariable(value = "noTelepon") String noTelepon,
            Model model
    ){
        // Mendapatkan HotelModel sesuai dgn idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        if(hotel != null) {
            // Mengganti no telepon
            hotel.setNoTelepon(noTelepon);

            // Add variable HotelModel ke 'hotel' untuk dirender pada thymeleaf
            model.addAttribute("hotel", hotel);

            return "update-success";
        }
        else{
            return "error-page";
        }
    }

    @GetMapping(value = "/hotel/delete/id-hotel/{idHotel}")
    public String deleteHotel(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ){
        // Mendapatkan HotelModel sesuai dgn idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        if(hotel != null) {
            // Menghapus hotel dari list
            hotelService.deleteHotel(idHotel);

            // Add variable HotelModel ke 'hotel' untuk dirender pada thymeleaf
            model.addAttribute("hotel", hotel);

            return "delete-success";
        }
        else{
            return "error-page";
        }
    }
}
