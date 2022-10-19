package practice.searchapi.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {

    @Test
    void 생성자_테스트() {
        Place place = new Place("미사", "경기도 하남시 풍산동", "123", "456", API.KAKAO);
        assertThat(place.getLocation()).isEqualTo(new Location("123", "456"));
    }

    @Test
    void 동일한_장소_테스트() {
        Place place = new Place("카카오프렌즈 스타필드 코엑스몰점", "서울 강남구 삼성동 159", "127.059028716089", "37.5120756277877", API.KAKAO);
        Place place_equal = new Place("카카오프렌즈 스타필드 코엑스몰점", "서울 강남구 삼성동 159", "127.059028716089", "37.5120756277877", API.KAKAO);
        Place place_space = new Place("<b>카카오프렌즈</b> 스타필드 <b>코엑스</b>몰점", "서울 강남구 삼성동 159", "127.059028716089", "37.5120756277877", API.KAKAO);

        assertAll("동일한 장소 판단 케이스 확인",
                () -> assertThat(place.isEqualName(place_equal)).isTrue(),
                () -> assertThat(place.isEqualName(place_space)).isTrue()
        );

    }

}