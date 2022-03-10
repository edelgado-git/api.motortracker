package api.motortracker.motortracker.service;

import api.motortracker.motortracker.model.AppUser;
import api.motortracker.motortracker.model.Car;
import api.motortracker.motortracker.model.Tracker;
import api.motortracker.motortracker.repository.AppUserRepository;
import api.motortracker.motortracker.repository.CarRepository;
import api.motortracker.motortracker.repository.TrackerRepository;
import api.motortracker.motortracker.resource.CarResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private TrackerRepository trackerRepository;

    public CarResource registerCar(CarResource carResource, String userName) {
        Tracker tracker = trackerRepository.findBySerialNumber(carResource.getTracker());
        AppUser appUser = appUserRepository.findByAwsCognitoId(userName);

        //TODO: validate tracker and user

        Car car = new Car();
        car.setAppUser(appUser);
        car.setName(carResource.getName());
        car.setPlate(carResource.getPlate());
        car.setTracker(tracker);

        carRepository.save(car);

        CarResource savedResource = new CarResource();
        savedResource.setId(car.getId());
        savedResource.setName(car.getName());
        savedResource.setPlate(car.getPlate());
        savedResource.setTracker(tracker.getSerialNumber());

        return savedResource;
    }
}
