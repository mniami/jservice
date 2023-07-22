package pl.bydgoszcz.guideme.jservice.datasource;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bydgoszcz.guideme.jservice.model.Place;
import pl.bydgoszcz.guideme.jservice.model.LocationResult;
import reactor.core.publisher.Flux;

@Component
public class HttpJsonPlaceDataSource implements IPlaceDataSource {
    private final WebClient.Builder webClientBuilder;
    public HttpJsonPlaceDataSource(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }
    public Flux<Place> fetchLocation(String url) {
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(LocationResult.class)
                .flatMap(item -> Flux.fromIterable(item.getPlaces()));
    }
}
