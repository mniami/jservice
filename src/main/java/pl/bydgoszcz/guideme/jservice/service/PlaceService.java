package pl.bydgoszcz.guideme.jservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import pl.bydgoszcz.guideme.jservice.filter.IPlaceFilter;
import pl.bydgoszcz.guideme.jservice.model.Place;
import pl.bydgoszcz.guideme.jservice.repository.IPlaceRepository;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class PlaceService implements IPlaceService {

    private final IPlaceRepository placeRepository;
    private final IPlaceFilter placeFilter;

    @Autowired
    public PlaceService(IPlaceRepository placeRepository, IPlaceFilter placeFilter) {
        this.placeRepository = placeRepository;
        this.placeFilter = placeFilter;
    }
    public Flux<Place> getPlaces(MultiValueMap<String, String> searchQuery) {
        Flux<Place> placeList = placeRepository.fetchPlaces();
        Flux<Place> filteredPlaceList = placeFilter.filterPlaces(placeList, searchQuery);
        return filteredPlaceList
                .subscribeOn(Schedulers.boundedElastic());
    }
}
