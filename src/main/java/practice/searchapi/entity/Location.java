package practice.searchapi.entity;

import java.util.Objects;

public class Location {

    private String x;

    private String y;

    public Location(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public Location(int x, int y) {
        this.x = String.valueOf(x);
        this.y = String.valueOf(y);
    }

    public Location(Location location) {
        this(location.getX(), location.getY());
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(x, location.x) && Objects.equals(y, location.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
