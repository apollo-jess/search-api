package practice.searchapi.service.dto;

import lombok.Getter;

@Getter
public class NaverSearchResponseItemDTO {

    private String title;

    private String link;

    private String category;

    private String telephone;

    private String address;

    private String roadAddress;

    private int mapx;

    private int mapy;

    private String description;

    @Override
    public String toString() {
        return "NaverSearchResponseItemDTO{" +
                "item='" + title + '\'' +
                ", link='" + link + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", roadAddress='" + roadAddress + '\'' +
                ", mapx=" + mapx +
                ", mapy=" + mapy +
                '}';
    }
}
