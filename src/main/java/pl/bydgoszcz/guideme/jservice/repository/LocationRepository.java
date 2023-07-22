package pl.bydgoszcz.guideme.jservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.bydgoszcz.guideme.jservice.datasource.ILocationDataSource;
import pl.bydgoszcz.guideme.jservice.datasource.ILocationDataSourceFactory;
import pl.bydgoszcz.guideme.jservice.model.Location;
import reactor.core.publisher.Flux;

@Repository
public class LocationRepository implements ILocationRepository{

    private final ILocationDataSourceFactory locationDataSourceFactory;

    @Autowired
    public LocationRepository(ILocationDataSourceFactory locationDataSourceFactory) {
        this.locationDataSourceFactory = locationDataSourceFactory;
    }
    public Flux<Location> fetchLocation(String url) {
        ILocationDataSource locationDataSource = locationDataSourceFactory.getHttpJsonLocationDataSource();
        return locationDataSource.fetchLocation(url);
    }
}
