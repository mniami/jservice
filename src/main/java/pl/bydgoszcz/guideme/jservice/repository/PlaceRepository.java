package pl.bydgoszcz.guideme.jservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.bydgoszcz.guideme.jservice.configuration.LocationConfig;
import pl.bydgoszcz.guideme.jservice.datasource.IPlaceDataSource;
import pl.bydgoszcz.guideme.jservice.datasource.IPlaceDataSourceFactory;
import pl.bydgoszcz.guideme.jservice.model.Place;
import reactor.core.publisher.Flux;

@Repository
public class PlaceRepository implements IPlaceRepository {

    private final IPlaceDataSourceFactory placeDataSourceFactory;
    private LocationConfig locationConfig;

    @Autowired
    public PlaceRepository(IPlaceDataSourceFactory placeDataSourceFactory, LocationConfig locationConfig) {
        this.placeDataSourceFactory = placeDataSourceFactory;
        this.locationConfig = locationConfig;
    }
    public Flux<Place> fetchPlaces() {
        IPlaceDataSource placeDataSource = placeDataSourceFactory.getHttpJsonPlacesDataSource();
        String url = locationConfig.getUrl();
        return placeDataSource.fetchLocation(url);
    }
}
