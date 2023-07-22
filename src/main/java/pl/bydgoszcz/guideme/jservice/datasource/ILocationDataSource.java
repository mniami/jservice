package pl.bydgoszcz.guideme.jservice.datasource;

import pl.bydgoszcz.guideme.jservice.model.Location;
import reactor.core.publisher.Flux;

public interface ILocationDataSource {
    Flux<Location> fetchLocation(String url);
}
