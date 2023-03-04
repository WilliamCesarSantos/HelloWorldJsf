package br.ada.americanas.jsf.helloworldjsf.car;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("car_view")
public class CarView implements Serializable {

    private static final long serialVersionUID = 1L;

    private CarService service;
    private Car car = new Car();

    @Inject
    public CarView(CarService service) {
        this.service = service;
    }

    public String save() {
        this.service.save(car);
        return "/car/list.xhtml?faces-redirect=true";
    }

    public List<Car> list() {
        return service.list();
    }

    public void edit(Car car) {
        this.car = car;
    }

    public void delete(Long id) {
        this.service.delete(id);
        this.car = new Car();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
