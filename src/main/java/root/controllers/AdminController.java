package root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import root.model.Flight;
import root.services.IFlightService;
import root.session.SessionObject;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
public class AdminController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IFlightService flightService;

    @RequestMapping(value = "/addFlight", method = RequestMethod.GET)
    public String addFlightForm(Model model) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("user", this.sessionObject.getUser());
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("flight", new Flight());
        return "addFlight";
    }

    @RequestMapping(value = "/addFlight", method = RequestMethod.POST)
    public String addFlight(@ModelAttribute Flight flight, @RequestParam MultipartFile obrazek) {
        System.out.println(obrazek);
        try {
            String filePath = "F:\\JAVA\\MAVEN\\beztytulu.jpg";
            obrazek.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        IFlightService.AddFlightResult result = this.flightService.addFlight(flight);
        if(result == IFlightService.AddFlightResult.PLACES_ADDED) {
            this.sessionObject.setInfo("Lenght increase");
        } else if(result == IFlightService.AddFlightResult.FLIGHT_ADDED) {
            this.sessionObject.setInfo("New flight added");
        }
        return "redirect:/addFlight";
    }

    @RequestMapping(value = "/editFlight/{id}", method = RequestMethod.GET)
    public String editFlightPage(@PathVariable int id, Model model) {
        Flight flight = this.flightService.getFlightById(id);
        model.addAttribute("flight", flight);
        model.addAttribute("user", this.sessionObject.getUser());
        return "editFlight";
    }

    @RequestMapping(value = "/editFlight/{id}", method = RequestMethod.POST)
    public String editFlight(@ModelAttribute Flight flight, @PathVariable int id) {
        flight.setId(id);
        this.flightService.updateFlight(flight);

        return "redirect:/main";
    }
}