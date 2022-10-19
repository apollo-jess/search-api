package practice.searchapi.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KeywordTest {

    @Test
    void 생성자_테스트() {
        Keyword keyword = new Keyword("카카오프렌즈");
        assertThat(keyword).isEqualTo(new Keyword("카카오프렌즈"));
    }

    @Test
    void 키워드_검색_횟수_증가_테스트() {
        Keyword keyword = new Keyword("카카오프렌즈");
        keyword.counted();
        assertThat(keyword.getCount()).isEqualTo(1L);
        keyword.counted();
        assertThat(keyword.getCount()).isEqualTo(2L);
    }

}