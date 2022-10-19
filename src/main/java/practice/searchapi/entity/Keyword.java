package practice.searchapi.entity;

import java.util.Objects;

public class Keyword {

    private final String keyword;

    private Long count = 0L;

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "keyword='" + keyword + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword1 = (Keyword) o;
        return Objects.equals(keyword, keyword1.keyword) && Objects.equals(count, keyword1.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword, count);
    }

    public void counted() {
        this.count++;
    }

    public Long getCount() {
        return count;
    }
}
