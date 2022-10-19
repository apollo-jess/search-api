package practice.searchapi.entity;

import java.util.Objects;

public class Name {

    private final String name;

    private final String nameForCompare;

    public Name(String name) {
        this.name = name;
        this.nameForCompare = trimmed(name);
    }

    public Name(Name name) {
        this(name.getName());
    }

    private String trimmed(String name) {
        return name
                .replaceAll("[\\s+]", "")
                .replaceAll("[<b|(/b)>]", "");
    }

    public String getName() {
        return name;
    }

    public String getNameForCompare() {
        return this.nameForCompare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
