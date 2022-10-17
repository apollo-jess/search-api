package practice.searchapi.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDTO {

    private String name;

    private String roadAddress;

    private String x;

    private String y;

    public PlaceDTO(String name, String roadAddress, String x, String y) {
        this.name = name;
        this.roadAddress = roadAddress;
        this.x = x;
        this.y = y;
    }
}
