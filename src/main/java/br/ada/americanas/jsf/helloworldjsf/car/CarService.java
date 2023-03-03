package br.ada.americanas.jsf.helloworldjsf.car;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CarService {

    private CarDAO dao;

    @Inject
    public CarService(CarDAO dao) {
        this.dao = dao;
    }

    public Car save(Car car) {
        if (car == null) {
            throw new NullPointerException("Car must not be null");
        }
        return dao.save(car);
    }

    public List<Car> list() {
        return dao.list();
    }

    public Car findById(Long id) {
        return dao.findById(id);
    }

    public Car delete(Long id) {
        return dao.delete(id);
    }

}
