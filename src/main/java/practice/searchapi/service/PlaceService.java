package practice.searchapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.searchapi.entity.Places;
import practice.searchapi.service.dto.PlaceDTO;
import practice.searchapi.service.search.KakaoAPI;
import practice.searchapi.service.search.NaverAPI;
import practice.searchapi.service.search.SearchAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final KeywordCommandService keywordCommandService;

    private final List<SearchAPI> searchAPIs = Arrays.asList(new KakaoAPI(), new NaverAPI());

    public List<PlaceDTO> getPlaces(String query) {
        List<Places> searchedPlaces = new ArrayList<>();
        for (SearchAPI searchAPI : searchAPIs) {
            searchedPlaces.add(searchAPI.searchPlaces(query));
        }
        keywordCommandService.countKeyword(query);

        Places places = new Places(searchedPlaces, 2);
        return places.toResponseDto();
    }
}