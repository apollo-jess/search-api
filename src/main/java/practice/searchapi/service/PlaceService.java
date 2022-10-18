package practice.searchapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.searchapi.entity.Places;
import practice.searchapi.service.dto.PlaceDTO;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final NaverSearchAPIService naverSearchAPIService;

    private final KakaoSearchAPIService kakaoSearchAPIService;

    public List<PlaceDTO> getPlaces(String query) {
        Places placesByNaverSearchAPI = new Places(naverSearchAPIService.search(query));
        Places placesByKakaoSearchAPI = new Places(kakaoSearchAPIService.search(query));

        Places places = new Places(Arrays.asList(placesByNaverSearchAPI, placesByKakaoSearchAPI), 2);

        return places.toResponseDto();
    }
}