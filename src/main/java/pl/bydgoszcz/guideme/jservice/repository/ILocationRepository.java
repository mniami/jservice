package pl.bydgoszcz.guideme.jservice.repository;

import pl.bydgoszcz.guideme.jservice.model.Location;
import reactor.core.publisher.Flux;

public interface ILocationRepository {
    Flux<Location> fetchLocation(String url);
}
