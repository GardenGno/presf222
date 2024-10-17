package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    public List<Car> carsList = new ArrayList<>();

    {
        carsList.add(new Car("BMW 3 Series", 1980, 241223));
        carsList.add(new Car("Chevrolet Corvette", 2000, 123456));
        carsList.add(new Car("Toyota Camry", 2006, 444444));
        carsList.add(new Car("Ford Mustang", 1999, 880555));
        carsList.add(new Car("Tesla Model S", 2015, 321000));
    }

    public List<Car> getCars(int count) {
        return carsList.subList(0, count);
    }
}
