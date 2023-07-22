package pl.bydgoszcz.guideme.jservice.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaceDataSourceFactory implements IPlaceDataSourceFactory {
    private HttpJsonPlaceDataSource httpJsonPlaceDataSource;

    @Autowired
    public PlaceDataSourceFactory(HttpJsonPlaceDataSource httpJsonPlaceDataSource) {

        this.httpJsonPlaceDataSource = httpJsonPlaceDataSource;
    }
    public IPlaceDataSource getHttpJsonPlacesDataSource() {
        return httpJsonPlaceDataSource;
    }
}
