package pl.bydgoszcz.guideme.jservice.datasource;

public interface IPlaceDataSourceFactory {
    IPlaceDataSource getHttpJsonPlacesDataSource();
}
