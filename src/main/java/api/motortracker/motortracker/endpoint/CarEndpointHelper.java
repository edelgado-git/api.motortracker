package api.motortracker.motortracker.endpoint;

import api.motortracker.motortracker.repository.CarRepository;
import api.motortracker.motortracker.resource.CarResource;
import api.motortracker.motortracker.service.CognitoClientSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarEndpointHelper {

    @Autowired
    private CognitoClientSService cognitoClientSService;

    public ResponseEntity<CarResource> registerCar(CarResource carResource, String userName, String accessToken) {

        boolean isUserAuthenticated = cognitoClientSService.isUserAuthenticated(userName, accessToken);

        if (!isUserAuthenticated) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        CarResource car = new CarResource();

        return new ResponseEntity<>(car, HttpStatus.UNAUTHORIZED);
    }
}
