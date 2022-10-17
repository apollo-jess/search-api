package practice.searchapi.service.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class NaverSearchResponseDTO {

    private String lastBuildDate;

    private int total;

    private int start;

    private int display;

    private List<NaverSearchResponseItemDTO> items;

    @Override
    public String toString() {
        return "NaverSearchResponseDTO{" +
                "lastBuildDate=" + lastBuildDate +
                ", total=" + total +
                ", start=" + start +
                ", display=" + display +
                ", items=" + items +
                '}';
    }
}
