package practice.searchapi.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NameTest {

    @Test
    void 장소이름_생성_규칙_테스트() {
        Name name = new Name("카카오프렌즈");
        Name name_space = new Name("카카오 프렌즈");
        Name name_btag = new Name("<b>카카오프렌즈</b>");

        assertAll("장소이름_생성_규칙_테스트",
                () -> assertThat(name).isEqualTo(new Name("카카오프렌즈")),
                () -> assertThat(name).isEqualTo(name_space),
                () -> assertThat(name).isEqualTo(name_btag));

    }
}
