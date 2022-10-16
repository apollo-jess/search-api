package practice.searchapi.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Places {

    private final List<Place> places;

    public Places() {
        this.places = new ArrayList<>();
    }

    public Places(List<Place> places) {
        this.places = places;
    }

    public Places(Places placesByKakao, Places placesByNaver) {
        this.places = new ArrayList<>(placesByKakao.getPlaces());
        merge(placesByNaver);
    }

    public void merge(Places places) {
        for (Place target : places.getPlaces()) {
            if (!containing(target)) {
                add(target);
            }
        }
    }

    private void add(Place place) {
        this.places.add(place);
    }

    private boolean containing(Place target) {
        return this.places.stream()
                .anyMatch(place -> place.isEqual(target));
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
