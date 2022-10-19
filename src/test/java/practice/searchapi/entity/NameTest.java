package practice.searchapi.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NameTest {

    Name name = new Name("카카오프렌즈");
    Name name_space = new Name("카카오 프렌즈");
    Name name_btag = new Name("<b>카카오프렌즈</b>");

    @Test
    void 장소이름_생성_규칙_테스트() {
        assertAll("장소이름_생성_규칙_테스트",
                () -> assertThat(name).isEqualTo(new Name("카카오프렌즈")),
                () -> assertThat(name).isEqualTo(name_space),
                () -> assertThat(name).isEqualTo(name_btag));

    }

    @Test
    void 원래의_이름과_동등비교를_위한_이름_생성_테스트() {
        assertAll("원래의_이름과_동등비교를_위한_이름_생성_테스트",
                () -> assertThat(name_space.getNameForCompare()).isEqualTo("카카오프렌즈"),
                () -> assertThat(name_space.getName()).isEqualTo("카카오 프렌즈")
        );
    }

    @Test
    void 동일_검색결과_이름_일치_여부_테스트() {
        assertAll("동일_검색결과_이름_일치_여부_테스트",
                () -> assertThat(name_btag.isEqual(name_space)).isTrue(),
                () -> assertThat(name_btag.isEqual(new Name("카카오프렌즈 코엑스점"))).isFalse()
        );
    }
}
