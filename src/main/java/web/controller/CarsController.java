package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String printCars(Model model){
        List<Car> cars = carService.carsList;
        model.addAttribute("cars", cars);
        return "cars";
    }
}
