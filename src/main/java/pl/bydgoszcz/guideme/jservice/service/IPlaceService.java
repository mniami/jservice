package pl.bydgoszcz.guideme.jservice.service;

import org.springframework.util.MultiValueMap;
import pl.bydgoszcz.guideme.jservice.model.Place;
import reactor.core.publisher.Flux;

public interface IPlaceService {
    Flux<Place> getPlaces(MultiValueMap<String, String> searchQuery);
}
