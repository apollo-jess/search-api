package practice.searchapi.util;

import practice.searchapi.entity.API;
import practice.searchapi.entity.Place;
import practice.searchapi.entity.Priority;

import java.util.Comparator;

public class PlaceComparator implements Comparator<Place> {

    @Override
    public int compare(Place place1, Place place2) {
        Priority priority1 = place1.getPriority();
        Priority priority2 = place2.getPriority();

        if (priority1.isDuplicated() && !priority2.isDuplicated()) {
            return -1;
        }

        if (priority1.getApi() == API.KAKAO && priority2.getApi() == API.NAVER) {
            return -1;
        }

        return 0;
    }
}
