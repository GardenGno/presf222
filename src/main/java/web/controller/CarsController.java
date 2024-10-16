package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarsController {

    private CarServiceImpl carService;

    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) String count,
                            ModelMap model) {
        if (count == null) {
            model.addAttribute("cars", carService.carsList);
        } else {
            if (Integer.valueOf(count) > 5) {
                model.addAttribute("cars", carService.carsList);
            } else if (Integer.valueOf(count) < 0) {
                model.addAttribute("cars", carService.carsList);
            } else {
                model.addAttribute("cars", carService.getCars(Integer.valueOf(count)));
            }
        }


        return "cars";
    }
}
