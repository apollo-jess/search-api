package practice.searchapi.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlacesTest {

    private static final Place 카카오프렌즈_서울역점_카카오 = new Place("카카오프렌즈 서울역점", "서울 중구 한강대로 405", "126.970586543568", "37.5546860417757", API.KAKAO);
    private static final Place 카카오프렌즈_코엑스점_카카오 = new Place("카카오프렌즈 스타필드 코엑스몰점", "서울 강남구 삼성동 159", "127.059028716089", "37.5120756277877", API.KAKAO);
    private static final Place 카카오프렌즈_홍대플래그십스토어 = new Place("카카오프렌즈_홍대플래그십스토어", "서울 마포구 양화로 162", "126.923919460392", "37.5563194254356", API.KAKAO);
    private static final Place 카카오프렌즈_서울역점_네이버 = new Place("<b>카카오프렌즈</b> 서울역점", "서울특별시 용산구 한강대로 405 서울역 KTX 역사내", "309345", "550792", API.NAVER);
    private static final Place 카카오프렌즈_코엑스점_네이버 = new Place("<b>카카오프렌즈</b> 스타필드 <b>코엑스</b>몰점", "서울특별시 강남구 영동대로 513 스타필드 코엑스몰 B1층 C108호", "317045", "545919", API.NAVER);
    private static final Place 카카오프렌즈_DDP점 = new Place("<b>카카오프렌즈</b> DDP점", "서울특별시 중구 을지로 281 DDP B2층 어울림광장", "312735", "552166", API.NAVER);

    @Test
    void 서로_다른_장소_Merge_테스트() {
        Places placesByKakao = new Places(Arrays.asList(카카오프렌즈_코엑스점_카카오));
        Places placesByNaver = new Places(Arrays.asList(카카오프렌즈_서울역점_네이버));

        Places places = new Places(placesByKakao, placesByNaver);

        assertThat(places).isEqualTo(new Places(Arrays.asList(카카오프렌즈_코엑스점_카카오, 카카오프렌즈_서울역점_네이버)));
    }

    @Test
    void 같은_장소_Merge_테스트() {
        Places placesByKakao = new Places(Arrays.asList(카카오프렌즈_서울역점_카카오));
        Places placesByNaver = new Places(Arrays.asList(카카오프렌즈_서울역점_네이버));

        Places places = new Places(placesByKakao, placesByNaver);

        assertThat(places).isEqualTo(new Places(Arrays.asList(카카오프렌즈_서울역점_카카오)));
    }

    @Test
    void 장소_Merge_복합_테스트() {
        Places placesByKakao = new Places(Arrays.asList(카카오프렌즈_서울역점_카카오, 카카오프렌즈_코엑스점_카카오, 카카오프렌즈_홍대플래그십스토어));
        Places placesByNaver = new Places(Arrays.asList(카카오프렌즈_서울역점_네이버, 카카오프렌즈_DDP점));

        Places places = new Places(placesByKakao, placesByNaver);

        assertThat(places).isEqualTo(new Places(Arrays.asList(카카오프렌즈_서울역점_카카오, 카카오프렌즈_코엑스점_카카오, 카카오프렌즈_홍대플래그십스토어, 카카오프렌즈_DDP점)));
    }

    @Test
    void 장소_sorting_테스트() {
        Places placesByKakao = new Places(Arrays.asList(카카오프렌즈_서울역점_카카오, 카카오프렌즈_홍대플래그십스토어, 카카오프렌즈_코엑스점_카카오));
        Places placesByNaver = new Places(Arrays.asList(카카오프렌즈_서울역점_네이버, 카카오프렌즈_코엑스점_네이버, 카카오프렌즈_DDP점));

        Places places = new Places(placesByKakao, placesByNaver);

        assertThat(places).isEqualTo(new Places(Arrays.asList(카카오프렌즈_서울역점_카카오, 카카오프렌즈_코엑스점_카카오, 카카오프렌즈_홍대플래그십스토어, 카카오프렌즈_DDP점)));
    }
}
