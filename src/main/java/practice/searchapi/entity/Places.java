package practice.searchapi.entity;

import practice.searchapi.util.PlaceComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Places {

    private static final int NOT_FOUND = -1;

    private final List<Place> places;

    public Places(List<Place> places) {
        this.places = places;
    }

    public Places(Places placesByKakao, Places placesByNaver) {
        this.places = new ArrayList<>(placesByKakao.getPlaces());
        merge(placesByNaver);
        sort();
    }

    public void merge(Places places) {
        for (Place place : places.getPlaces()) {
            if (containing(place)) {
                changePlacePriorityIfDuplicated(place);
                continue;
            }
            this.places.add(place);
        }
    }

    private void changePlacePriorityIfDuplicated(Place place) {
        int index = getDuplicatedPlaceIndexWith(place);
        if (index != NOT_FOUND) {
            this.places.add(new Place(this.places.get(index), true));
            this.places.remove(index);
        }
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
        this.places.sort(new PlaceComparator());
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
}
