package pl.bydgoszcz.guideme.jservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bydgoszcz.guideme.jservice.component.LocationConfig;
import pl.bydgoszcz.guideme.jservice.datasource.ILocationDataSource;
import pl.bydgoszcz.guideme.jservice.model.Location;
import pl.bydgoszcz.guideme.jservice.repository.ILocationRepository;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class LocationService implements ILocationService {

    private ILocationRepository locationRepository;
    private LocationConfig locationConfig;

    @Autowired
    public LocationService(ILocationRepository locationRepository, LocationConfig locationConfig) {
        this.locationRepository = locationRepository;
        this.locationConfig = locationConfig;
    }
    public Flux<Location> getLocations() {
        Flux<Location> result = locationRepository.fetchLocation(locationConfig.getUrl());
        return result
                .subscribeOn(Schedulers.boundedElastic());
    }
}
