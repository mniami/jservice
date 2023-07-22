package pl.bydgoszcz.guideme.jservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bydgoszcz.guideme.jservice.model.Place;
import pl.bydgoszcz.guideme.jservice.repository.IPlaceRepository;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;

@Service
public class PlaceService implements IPlaceService {

    private IPlaceRepository placeRepository;

    @Autowired
    public PlaceService(IPlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
    public Flux<Place> getPlaces(Optional<String> location, Optional<String> searchQuery) {
        Flux<Place> result = placeRepository.fetchPlaces();
        return result
                .subscribeOn(Schedulers.boundedElastic());
    }
}
