package pl.bydgoszcz.guideme.jservice.filter;

import org.springframework.util.MultiValueMap;
import pl.bydgoszcz.guideme.jservice.model.Place;
import reactor.core.publisher.Flux;

public interface IPlaceFilter {
    Flux<Place> filterPlaces(Flux<Place> placeList, MultiValueMap<String, String> searchQuery);
}
