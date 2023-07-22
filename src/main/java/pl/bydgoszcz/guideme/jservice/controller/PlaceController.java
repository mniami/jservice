package pl.bydgoszcz.guideme.jservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bydgoszcz.guideme.jservice.model.Place;
import pl.bydgoszcz.guideme.jservice.service.IPlaceService;
import reactor.core.publisher.Flux;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PlaceController {

    private final IPlaceService placeService;

    @Autowired
    public PlaceController(IPlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/place")
    public Flux<Place> getPlaces(Optional<String> location, Optional<String> searchQuery) {
        return placeService.getPlaces(location, searchQuery);
    }
}