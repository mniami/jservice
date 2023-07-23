package pl.bydgoszcz.guideme.jservice.filter;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import pl.bydgoszcz.guideme.jservice.model.Place;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Predicate;

@Component
public class PlaceFilter implements IPlaceFilter {
    public Flux<Place> filterPlaces(Flux<Place> placeList, MultiValueMap<String, String> searchQuery) {
        Predicate<Place> filterPredicate = createFilterPredicate(searchQuery);
        return placeList.filter(filterPredicate);
    }

    private Predicate<Place> createFilterPredicate(MultiValueMap<String, String> searchQuery) {
        return place -> searchQuery.entrySet().stream()
                .allMatch(entry -> {
                    String key = entry.getKey();
                    List<String> values = entry.getValue();
                    return values.contains(getPropertyValue(place, key));
                });
    }
    private String getPropertyValue(Place place, String propertyName) {
        switch (propertyName) {
            case "id":
                return String.valueOf(place.getId());
            case "lat":
                return String.valueOf(place.getLat());
            case "lon":
                return String.valueOf(place.getLon());
            case "name":
                return place.getName();
            case "partnerId":
                return place.getPartnerId();
            case "placeId":
                return place.getPlaceId();
            case "wifiCheckingEnabled":
                return String.valueOf(place.getWifiCheckingEnabled());
            case "wifis":
                return String.valueOf(place.getWifis());
            case "zipCode":
                return place.getZipCode();
            case "countryCode":
                return place.getCountryCode();
            case "features":
                return String.valueOf(place.getFeatures());
            case "street":
                return place.getStreet();
            case "city":
                return place.getCity();
            default:
                return ""; // Or handle unknown property names accordingly
        }
    }
}
