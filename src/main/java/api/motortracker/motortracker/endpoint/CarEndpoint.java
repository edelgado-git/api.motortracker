package api.motortracker.motortracker.endpoint;

import api.motortracker.motortracker.http.HttpHeaders;
import api.motortracker.motortracker.repository.CarRepository;
import api.motortracker.motortracker.resource.CarResource;
import api.motortracker.motortracker.service.CognitoClientSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = CarEndpoint.BASE_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarEndpoint {

    public static final String BASE_ENDPOINT = "/car";

    @Autowired
    private CarEndpointHelper helper;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarResource> registerCar(
            @RequestHeader(value = HttpHeaders.MOTOR_TRACKER_USERNAME) String userName,
            @RequestHeader(value = HttpHeaders.MOTOR_TRACKER_ACCESS_TOKEN) String accessToken,
            @RequestBody CarResource carResource) {

        return helper.registerCar(carResource, userName, accessToken);
    }

    @GetMapping(value = "/test")
    @CrossOrigin(origins = "http://localhost:3000")
    public String test(
            @RequestHeader(value = HttpHeaders.MOTOR_TRACKER_USERNAME) String userName,
            @RequestHeader(value = HttpHeaders.MOTOR_TRACKER_ACCESS_TOKEN) String accessToken) {


        return "test";
    }
}