package pl.bydgoszcz.guideme.jservice.service;

import pl.bydgoszcz.guideme.jservice.model.Place;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface IPlaceService {
    Flux<Place> getPlaces(Optional<String> location, Optional<String> searchQuery);
}
