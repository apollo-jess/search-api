package practice.searchapi.util;

import practice.searchapi.entity.Place;

import java.util.Comparator;

public class PlaceComparator implements Comparator<Place> {

    @Override
    public int compare(Place place1, Place place2) {
        if (place1.isHigherPriorityPlaceThan(place2)) {
            return -1;
        }

        return 0;
    }
}
