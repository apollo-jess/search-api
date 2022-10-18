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

    public Places(Places places1, Places places2) {
        this.places = new ArrayList<>(places1.getPlaces());
        mergePlaces(places2);
        sort();
    }

    public Places(NaverSearchResponseDTO dto) {
        this.places = new ArrayList<>();
        for (NaverSearchResponseItemDTO item : dto.getItems()) {
            Place place = new Place(item);
            this.places.add(place);
        }
    }

    public Places(KakaoSearchResponseDTO dto) {
        this.places = new ArrayList<>();
        for (KakaoSearchResponseDocumentsDTO document : dto.getDocuments()) {
            Place place = new Place(document);
            this.places.add(place);
        }
    }

    public void mergePlaces(Places places) {
        for (Place place : places.getPlaces()) {
            merge(place);
        }
    }

    private void merge(Place place) {
        if (isDuplicated(place)) {
            changeDuplicatedPlace(place);
            return;
        }
        this.places.add(place);
    }

    private boolean isDuplicated(Place place) {
        return this.places.stream()
                .anyMatch(p -> p.isEqual(place));
    }

    private void changeDuplicatedPlace(Place place) {
        int index = getDuplicatedPlaceIndexWith(place);
        if (index == NOT_FOUND) {
            return ;
        }

        Place higherPriorityPlace
                = this.places.get(index).isHigherPriorityPlaceThan(place)
                ? this.places.get(index) : place;

        this.places.add(new Place(higherPriorityPlace, DUPLICATED));
        this.places.remove(index);
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
