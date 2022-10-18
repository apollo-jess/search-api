package practice.searchapi.entity;

import practice.searchapi.service.dto.KakaoSearchResponseDocumentsDTO;
import practice.searchapi.service.dto.NaverSearchResponseItemDTO;
import practice.searchapi.service.dto.PlaceDTO;

import java.util.Objects;

public class Place {

    private final Name name;

    private final String roadAddress;

    private final Location location;

    private final Priority priority;

    public Place(String name, String roadAddress, String x, String y, API API) {
        this.name = new Name(name);
        this.roadAddress = roadAddress;
        this.location = new Location(x, y);
        this.priority = new Priority(API);
    }

    public Place(Place place, boolean duplicated) {
        this.name = new Name(place.getName());
        this.roadAddress = place.getRoadAddress();
        this.location = new Location(place.getLocation());
        this.priority = new Priority(place.getPriority(), duplicated);
    }

    public Place(KakaoSearchResponseDocumentsDTO document) {
        this(document.getPlace_name(), document.getRoad_address_name(), document.getX(), document.getY(), API.KAKAO);
    }

    public Place(NaverSearchResponseItemDTO item) {
        this(item.getTitle(), item.getRoadAddress(), String.valueOf(item.getMapx()), String.valueOf(item.getMapy()), API.NAVER);
    }

    public boolean isEqual(Place target) {
        return this.name.equals(target.getName());
    }

    public boolean isHigherPriorityPlaceThan(Place another) {
        return this.priority.isHigherPriorityThan(another.getPriority());
    }

    public Name getName() {
        return name;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public Location getLocation() {
        return location;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name=" + name +
                ", roadAddress='" + roadAddress + '\'' +
                ", location=" + location +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(name, place.name) && Objects.equals(roadAddress, place.roadAddress) && Objects.equals(location, place.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roadAddress, location);
    }

    public PlaceDTO toDto() {
        return new PlaceDTO(name.getName(), roadAddress, getLocation().getX(), getLocation().getY());
    }
}
