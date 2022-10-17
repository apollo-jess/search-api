package practice.searchapi.service.dto;

public class NaverSearchResponseItemDTO {

    private String item;

    private String link;

    private String category;

    private String description;

    private String telephone;

    private String address;

    private String roadAddress;

    private int mapx;

    private int mapy;

    @Override
    public String toString() {
        return "NaverSearchResponseItemDTO{" +
                "item='" + item + '\'' +
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
