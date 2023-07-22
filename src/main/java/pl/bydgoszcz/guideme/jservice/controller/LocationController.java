package pl.bydgoszcz.guideme.jservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bydgoszcz.guideme.jservice.model.Location;
import pl.bydgoszcz.guideme.jservice.service.ILocationService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
public class LocationController {

    private final ILocationService locationService;

    @Autowired
    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    public Flux<Location> getLocations() {
        return locationService.getLocations();
    }
}