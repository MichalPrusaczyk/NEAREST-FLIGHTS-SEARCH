package root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import root.services.IBasketService;
import root.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class BasketController {

    @Autowired
    IBasketService basketService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/addToBasket/{id}", method = RequestMethod.GET)
    public String addFlightToBasket(@PathVariable int id) {
        if (sessionObject.isLogged()) {
            this.basketService.addToBasket(id);
            return "redirect:/main";
        } else {
            this.sessionObject.setInfo("Please login to order your flight");
        return "redirect:/login";
    }
    }


    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showBasket(Model model) {
        model.addAttribute("flights", this.sessionObject.getBasket());
        model.addAttribute("user", this.sessionObject.getUser());
        model.addAttribute("bill", this.basketService.calculateBill());
        return "basket";
    }

    @RequestMapping(value = "/remove-flight-from-basket/{id}", method = RequestMethod.GET)
    public String removeFlightFormBasket(@PathVariable int id) {
        this.basketService.removeFlightFromBasket(id);
        return "redirect:/basket";
    }
}