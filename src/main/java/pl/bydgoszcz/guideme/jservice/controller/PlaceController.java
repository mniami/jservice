package pl.bydgoszcz.guideme.jservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bydgoszcz.guideme.jservice.model.Place;
import pl.bydgoszcz.guideme.jservice.service.IPlaceService;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class PlaceController {
    private static final Logger logger = LoggerFactory.getLogger(PlaceController.class);

    private final IPlaceService placeService;

    @Autowired
    public PlaceController(IPlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/place")
    public Flux<Place> getPlaces(@RequestParam MultiValueMap<String, String> searchQuery) {
        var queryParamsKeys = searchQuery.keySet().stream().map(key -> key + ": " + searchQuery.get(key)).collect(Collectors.joining());
        logger.debug(String.format("GET /place query params: %s", queryParamsKeys));

        return placeService.getPlaces(searchQuery);
    }
}