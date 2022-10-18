package practice.searchapi.service.dto;

import lombok.Getter;

@Getter
public class KakaoSearchResponseDocumentsDTO {

    private String id;

    private String place_name;

    private String place_url;

    private String category_name;

    private String phone;

    private String address_name;

    private String road_address_name;

    private String x;

    private String y;

    private String category_group_code;

    private String category_group_name;

    private String distance;

    @Override
    public String toString() {
        return "KakaoSearchResponseDocumentsDTO{" +
                "id='" + id + '\'' +
                ", place_name='" + place_name + '\'' +
                ", category_name='" + category_name + '\'' +
                ", category_group_code='" + category_group_code + '\'' +
                ", category_group_name='" + category_group_name + '\'' +
                ", phone='" + phone + '\'' +
                ", address_name='" + address_name + '\'' +
                ", road_address_name='" + road_address_name + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", place_url='" + place_url + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
