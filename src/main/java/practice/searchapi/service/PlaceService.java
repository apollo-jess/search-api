package practice.searchapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final NaverSearchAPIService naverSearchAPIService;

    public void getPlaces(String query) {
        naverSearchAPIService.search(query);
    }
}