package practice.searchapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practice.searchapi.service.PlaceService;
import practice.searchapi.service.dto.PlaceDTO;
import practice.searchapi.service.search.KakaoAPI;
import practice.searchapi.service.search.NaverAPI;
import practice.searchapi.service.search.SearchAPI;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/places")
public class PlaceController {
    public PlaceController() {
        SearchAPI kakaoAPI = new KakaoAPI();
        SearchAPI naverAPI = new NaverAPI();
        this.placeService = new PlaceService(Arrays.asList(kakaoAPI, naverAPI));
    }

    private final PlaceService placeService;

    @GetMapping
    public ResponseEntity<List<PlaceDTO>> getPlaces(@RequestParam(name = "query", required = true) String query) {
        List<PlaceDTO> places = placeService.getPlaces(query);

        return ResponseEntity.ok().body(places);
    }

}
