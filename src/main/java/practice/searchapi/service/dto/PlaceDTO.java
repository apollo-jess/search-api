package practice.searchapi.service.dto;

import lombok.Getter;
import lombok.Setter;
import practice.searchapi.entity.API;

@Getter
@Setter
public class PlaceDTO {

    private String name;

    private String roadAddress;

    private String x;

    private String y;

    private String searchedBy;

    public PlaceDTO(String name, String roadAddress, String x, String y, API api) {
        this.name = name.replaceAll("[<b|(/b)>]", "");;
        this.roadAddress = roadAddress;
        this.x = x;
        this.y = y;
        this.searchedBy = api.getType();
    }
}
