package pl.bydgoszcz.guideme.jservice.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationDataSourceFactory implements ILocationDataSourceFactory {
    private HttpJsonLocationDataSource httpJsonLocationDataSource;

    @Autowired
    public LocationDataSourceFactory(HttpJsonLocationDataSource httpJsonLocationDataSource) {

        this.httpJsonLocationDataSource = httpJsonLocationDataSource;
    }
    public ILocationDataSource getHttpJsonLocationDataSource() {
        return httpJsonLocationDataSource;
    }
}
