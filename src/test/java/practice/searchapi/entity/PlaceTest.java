package practice.searchapi.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {

    @Test
    void 생성자_테스트() {
        Place place = new Place("미사", "경기도 하남시 풍산동", "123", "456");
        assertThat(place.getLocation()).isEqualTo(new Location("123", "456"));

    }

    @Test
    void 동일한_장소_테스트() {
        Place place = new Place("미사 조정 경기장", "경기도 하남시 풍산동", "123", "456");
        Place place_equal = new Place("미사 조정 경기장", "경기도 하남시 풍산동", "123", "456");
        Place place_space = new Place("미사  조정 경기장", "경기도 하남시 풍산동", "123", "456");

        assertAll("동일한 장소 판단 케이스 확인",
                () -> assertThat(place.compare(place_equal)).isTrue(),
                () -> assertThat(place.compare(place_space)).isTrue()
        );

    }

}