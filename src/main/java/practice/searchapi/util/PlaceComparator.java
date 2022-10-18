package practice.searchapi.util;

import practice.searchapi.entity.Place;
import practice.searchapi.entity.Priority;

import java.util.Comparator;

public class PlaceComparator implements Comparator<Place> {

    @Override
    public int compare(Place place1, Place place2) {
        Priority priority1 = place1.getPriority();
        Priority priority2 = place2.getPriority();

        return priority1.isHigherPriorityThan(priority2);
    }
}
