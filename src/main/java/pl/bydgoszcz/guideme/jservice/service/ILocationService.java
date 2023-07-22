package pl.bydgoszcz.guideme.jservice.service;

import pl.bydgoszcz.guideme.jservice.model.Location;
import reactor.core.publisher.Flux;

public interface ILocationService {
    Flux<Location> getLocations();
}
