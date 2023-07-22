package pl.bydgoszcz.guideme.jservice.datasource;

import pl.bydgoszcz.guideme.jservice.model.Place;
import reactor.core.publisher.Flux;

public interface IPlaceDataSource {
    Flux<Place> fetchLocation(String url);
}
