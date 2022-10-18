package practice.searchapi.service;

import org.springframework.stereotype.Service;
import practice.searchapi.entity.Places;
import practice.searchapi.service.dto.PlaceDTO;
import practice.searchapi.service.search.SearchAPI;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {

    public PlaceService(List<SearchAPI> searchAPIs) {
        this.searchAPIs = searchAPIs;
    }

    private final List<SearchAPI> searchAPIs;

    public List<PlaceDTO> getPlaces(String query) {
        List<Places> searchedPlaces = new ArrayList<>();
        for (SearchAPI searchAPI : searchAPIs) {
            searchedPlaces.add(searchAPI.searchPlaces(query));
        }

        Places places = new Places(searchedPlaces, 2);
        return places.toResponseDto();
    }
}