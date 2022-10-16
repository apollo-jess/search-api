package practice.searchapi.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Places {

    private final List<Place> places;

    public Places(List<Place> places) {
        this.places = places;
    }

    public Places(Places placesByKakao, Places placesByNaver) {
        this.places = merge(placesByKakao, placesByNaver);
    }

    public List<Place> merge(Places places1, Places places2) {
        List<Place> places = new ArrayList<>();

        places.addAll(places1.getPlaces());
        places.addAll(places2.getPlaces());

        return places;
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
