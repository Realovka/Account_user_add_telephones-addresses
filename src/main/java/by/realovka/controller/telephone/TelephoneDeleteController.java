package by.realovka.controller.telephone;

import by.realovka.dto.TelephoneDTO;
import by.realovka.entity.User;
import by.realovka.service.TelephoneService;
import by.realovka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/deleteTelephone")
public class TelephoneDeleteController {

    @Autowired
    private UserService userService;
    @Autowired
    private TelephoneService telephoneService;

    @GetMapping(path = "/deleteTelephone/{id}")
    public ModelAndView getDeleteTelephone(@PathVariable long id, HttpSession httpSession, ModelAndView modelAndView){
        User auth = (User) httpSession.getAttribute("userAuth");
        telephoneService.deleteTelephone(id);
        User userAndHisTelephones = userService.getAuthUser(auth);
        modelAndView.addObject("userAndHisTelephones",userAndHisTelephones);
        modelAndView.addObject("telephone", new TelephoneDTO());
        modelAndView.setViewName("telephone");
        return modelAndView;
    }
}
