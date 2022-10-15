package practice.searchapi.entity;

import java.util.Objects;

public class Place {

    private final String title;

    private final String address;

    private final Location location;

    public Place(String title, String address, String x, String y) {
        this.title = title;
        this.address = address;
        this.location = new Location(x, y);
    }

    public boolean compare(Place target) {
        return this.title.replaceAll("[\\s+]", "")
                .equals(target.getTitle().replaceAll("[\\s+]", ""));
    }

    public String getTitle() {
        return title;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Place{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(title, place.title) && Objects.equals(address, place.address) && Objects.equals(location, place.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, address, location);
    }
}
