package pl.bydgoszcz.guideme.jservice.datasource;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bydgoszcz.guideme.jservice.model.Location;
import pl.bydgoszcz.guideme.jservice.model.LocationResult;
import reactor.core.publisher.Flux;

@Component
public class HttpJsonLocationDataSource implements ILocationDataSource {
    private final WebClient.Builder webClientBuilder;
    public HttpJsonLocationDataSource(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }
    public Flux<Location> fetchLocation(String url) {
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(LocationResult.class)
                .flatMap(item -> Flux.fromIterable(item.getPlaces()));
    }
}
