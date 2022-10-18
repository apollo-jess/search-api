package practice.searchapi.entity;

import practice.searchapi.service.dto.KakaoSearchResponseDTO;
import practice.searchapi.service.dto.KakaoSearchResponseDocumentsDTO;
import practice.searchapi.service.dto.NaverSearchResponseDTO;
import practice.searchapi.service.dto.NaverSearchResponseItemDTO;
import practice.searchapi.service.dto.PlaceDTO;
import practice.searchapi.util.PlaceComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Places {

    private static final int NOT_FOUND = -1;

    private static final boolean DUPLICATED = true;

    private static final PlaceComparator placeComparator = new PlaceComparator();

    private final List<Place> places;

    public Places(List<Place> places) {
        this.places = places;
    }

    public Places(Places placesByKakao, Places placesByNaver) {
        this.places = new ArrayList<>(placesByKakao.getPlaces());
        merge(placesByNaver);
        sort();
    }

    public Places(NaverSearchResponseDTO dto) {
        this.places = new ArrayList<>();
        for (NaverSearchResponseItemDTO item : dto.getItems()) {
            Place place = new Place(item.getTitle(), item.getRoadAddress(), item.getMapx(), item.getMapy(), API.NAVER);
            this.places.add(place);
        }
    }

    public Places(KakaoSearchResponseDTO dto) {
        this.places = new ArrayList<>();
        for (KakaoSearchResponseDocumentsDTO document : dto.getDocuments()) {
            Place place = new Place(document.getPlace_name(), document.getRoad_address_name(), document.getX(), document.getY(), API.KAKAO);
            this.places.add(place);
        }
    }

    public void merge(Places places) {
        for (Place place : places.getPlaces()) {
            int index = getDuplicatedPlaceIndexWith(place);
            if (index != NOT_FOUND) {
                changePlacePriority(index, place);
                continue;
            }
            this.places.add(place);
        }
    }

    private void changePlacePriority(int index, Place place) {
        Place higherPriorityPlace
                = this.places.get(index).isHigherPriorityPlaceThan(place)
                ? this.places.get(index) : place;

        this.places.add(new Place(higherPriorityPlace, DUPLICATED));
        this.places.remove(index);
    }

    private boolean containing(Place place) {
        return this.places.stream()
                .anyMatch(p -> p.isEqual(place));
    }

    private int getDuplicatedPlaceIndexWith(Place target) {
        for (int i = 0; i < this.places.size(); i++) {
            if (this.places.get(i).isEqual(target)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void sort() {
        this.places.sort(placeComparator);
    }

    public List<Place> getPlaces() {
        return Collections.unmodifiableList(places);
    }

    @Override
    public String toString() {
        return "Places{" +
                "places=" + places +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Places places1 = (Places) o;
        return Objects.equals(places, places1.places);
    }

    @Override
    public int hashCode() {
        return Objects.hash(places);
    }

    public List<PlaceDTO> toResponseDto() {
        List<PlaceDTO> placeDTOs = new ArrayList<PlaceDTO>();

        for (Place place : this.places) {
            PlaceDTO placeDto = place.toDto();
            placeDTOs.add(placeDto);
        }

        return placeDTOs;
    }
}
