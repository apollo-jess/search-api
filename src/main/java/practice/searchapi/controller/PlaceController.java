package practice.searchapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practice.searchapi.service.PlaceService;
import practice.searchapi.service.dto.PlaceDTO;

import java.util.List;

@RestController
@RequestMapping("/v1/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public ResponseEntity<List<PlaceDTO>> getPlaces(@RequestParam(name = "query", required = true) String query) {
        List<PlaceDTO> places = placeService.getPlaces(query);

        return ResponseEntity.ok().body(places);
    }

}
