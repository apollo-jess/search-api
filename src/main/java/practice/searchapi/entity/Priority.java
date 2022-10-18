package practice.searchapi.entity;

import java.util.Objects;

public class Priority {

    private final API api;

    private final boolean duplicated;

    public Priority(API api) {
        this.api = api;
        this.duplicated = false;
    }

    public Priority(Priority priority, boolean duplicated) {
        this.api = priority.getApi();
        this.duplicated = duplicated;
    }

    public API getApi() {
        return api;
    }

    public boolean isDuplicated() {
        return duplicated;
    }

    public int isHigherPriorityThan(Priority another) {
        if (this.duplicated && !another.isDuplicated()) {
            return -1;
        }

        if (this.api.isHigherThan(another.getApi())) {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "api=" + api +
                ", duplicated=" + duplicated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority = (Priority) o;
        return duplicated == priority.duplicated && api == priority.api;
    }

    @Override
    public int hashCode() {
        return Objects.hash(api, duplicated);
    }
}
