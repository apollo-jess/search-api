package practice.searchapi.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlacesTest {

    private static final Place 카카오프렌즈_코엑스점 = new Place("카카오프렌즈 스타필드 코엑스몰점", "서울 강남구 삼성동 159", "127.059028716089", "37.5120756277877");
    private static final Place 카카오프렌즈_서울역점 = new Place("<b>카카오프렌즈</b> 서울역점", "서울특별시 용산구 한강대로 405 서울역 KTX 역사내", "309345", "550792");

    @Test
    void 서로_다른_장소_Merge_테스트() {
        Places placesByKakao = new Places(Arrays.asList(카카오프렌즈_코엑스점));
        Places placesByNaver = new Places(Arrays.asList(카카오프렌즈_서울역점));

        Places places = new Places(placesByKakao, placesByNaver);

        assertThat(places).isEqualTo(new Places(Arrays.asList(카카오프렌즈_코엑스점, 카카오프렌즈_서울역점)));
    }
}
