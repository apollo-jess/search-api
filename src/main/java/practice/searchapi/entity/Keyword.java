package practice.searchapi.entity;

import lombok.NoArgsConstructor;
import practice.searchapi.service.dto.KeywordDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "keyword")
@NoArgsConstructor
public class Keyword extends BaseTimeEntity {

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

    public void counted() {
        this.count++;
    }

    public Long getCount() {
        return count;
    }

    public KeywordDTO toDTO() {
        return new KeywordDTO(this.name, this.count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword = (Keyword) o;
        return Objects.equals(id, keyword.id) && Objects.equals(name, keyword.name) && Objects.equals(count, keyword.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, count);
    }
}
