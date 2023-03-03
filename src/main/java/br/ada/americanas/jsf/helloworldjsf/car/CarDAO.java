package br.ada.americanas.jsf.helloworldjsf.car;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CarDAO {

    private Map<Long, Car> CARS = new HashMap<>();

    public Car save(Car car) {
        if (car.getId() == null) {
            car.setId(System.currentTimeMillis());
        }
        CARS.put(car.getId(), car);
        return car;
    }

    public Car findById(Long id) {
        return CARS.get(id);
    }

    public List<Car> list() {
        return new ArrayList<>(CARS.values());
    }

    public Car delete(Long id) {
        return CARS.remove(id);
    }

}
