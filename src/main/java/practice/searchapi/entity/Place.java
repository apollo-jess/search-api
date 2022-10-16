package practice.searchapi.entity;

import java.util.Objects;

public class Place {

    private final String name;

    private final String address;

    private final Location location;

    public Place(String name, String address, String x, String y) {
        this.name = name;
        this.address = address;
        this.location = new Location(x, y);
    }

    public boolean compare(Place target) {
        return this.name.replaceAll("[\\s+]", "")
                .equals(target.getName().replaceAll("[\\s+]", ""));
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Place{" +
                "title='" + name + '\'' +
                ", address='" + address + '\'' +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(name, place.name) && Objects.equals(address, place.address) && Objects.equals(location, place.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, location);
    }
}
