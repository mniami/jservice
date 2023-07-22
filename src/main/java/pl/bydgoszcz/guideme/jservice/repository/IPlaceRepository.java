package pl.bydgoszcz.guideme.jservice.repository;

import pl.bydgoszcz.guideme.jservice.model.Place;
import reactor.core.publisher.Flux;

public interface IPlaceRepository {
    Flux<Place> fetchPlaces();
}
