package practice.searchapi.entity;

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

    public boolean isEqual(Place target) {
        return this.name.equals(target.getName());
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
}
