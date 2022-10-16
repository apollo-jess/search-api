package practice.searchapi.entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Place {

    private final Name name;

    private final String roadAddress;

    private final Location location;

    public Place(String name, String roadAddress, String x, String y) {
        this.name = new Name(name);
        this.roadAddress = roadAddress;
        this.location = new Location(x, y);
    }

    public boolean isEqual(Place target) {
        return this.name.equals(target.getName());
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Place{" +
                "title='" + name + '\'' +
                ", address='" + roadAddress + '\'' +
                ", location=" + location +
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
