package pl.bydgoszcz.guideme.jservice.filter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.bydgoszcz.guideme.jservice.model.Place;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlaceFilterTests {

    @Test
    void testFilterPlaces() {
        PlaceFilter itemFilter = new PlaceFilter();

        Place item1 = new Place(1, 4, 3, "Hyde Park", "", "", false, new ArrayList<>(), "", "PL", new ArrayList<>(), "", "");
        Place item2 = new Place(2, 5, 4, "Olympic Center", "", "", false, new ArrayList<>(), "", "UK", new ArrayList<>(), "", "");
        Place item3 = new Place(3, 6, 5, "Crawlers", "", "", false, new ArrayList<>(), "", "GB", new ArrayList<>(), "", "");
        Place item4 = new Place(4, 7, 6, "Crawlers", "", "", false, new ArrayList<>(), "", "ES", new ArrayList<>(), "", "");

        List<Place> items = List.of(item1, item2, item3, item4);
        Flux<Place> itemsFlux = Flux.fromIterable(items);

        // Test with different search queries
        MultiValueMap<String, String> searchQuery1 = new LinkedMultiValueMap<>();

        searchQuery1.add("name", "Hyde Park");

        Flux<Place> filteredItems1 = itemFilter.filterPlaces(itemsFlux, searchQuery1);
        assertEquals(List.of(item1), filteredItems1.collectList().block());

        MultiValueMap<String, String> searchQuery2 = new LinkedMultiValueMap<>();
        searchQuery2.add("countryCode", "GB");
        searchQuery2.add("name", "Crawlers");

        Flux<Place> filteredItems2 = itemFilter.filterPlaces(itemsFlux, searchQuery2);
        assertEquals(List.of(item3), filteredItems2.collectList().block());
    }
}
