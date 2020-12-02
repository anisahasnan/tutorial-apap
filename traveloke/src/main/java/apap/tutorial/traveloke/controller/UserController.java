package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @Autowired
//    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @RequestMapping(value = "/updatePass", method = RequestMethod.POST)
    public String updatePasswordSubmit(
            HttpServletRequest request,
            Model model){

        String username = request.getRemoteUser();
        String oldPass = request.getParameter("oldpassword");
        String newPass = request.getParameter("newpassword");
        String confirmPass = request.getParameter("confirmpassword");

        UserModel user = userService.getUserByUsername(username);

        String pesan;
        if(userService.validateOldPassword(user, oldPass)){
            if(newPass.equals(oldPass)){
                pesan = "Password baru tidak boleh sama dengan password lama!";
            }
            else if(confirmPass.equals(newPass)){
                userService.updatePassword(user, newPass);
                pesan = "Password berhasil diupdate!";
            }
            else{
                pesan = "Konfirmasi password tidak sama!";
            }
        }
        else{
            pesan = "Password lama salah!";
        }
        model.addAttribute("pesan", pesan);
        return "home";
    }
}
