package practice.searchapi.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Keyword {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "count")
    private Long count = 0L;

    public Keyword(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "keyword='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword1 = (Keyword) o;
        return Objects.equals(name, keyword1.name) && Objects.equals(count, keyword1.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }

    public void counted() {
        this.count++;
    }

    public Long getCount() {
        return count;
    }
}
