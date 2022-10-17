package practice.searchapi.service.dto;

import java.util.Arrays;

public class KakaoSearchResponseMetaRegionInfo {

    private String[] region;

    private String keyword;

    private String selected_region;

    public KakaoSearchResponseMetaRegionInfo() {
    }

    @Override
    public String toString() {
        return "KakaoSearchResponseMetaRegionInfo{" +
                "region=" + Arrays.toString(region) +
                ", keyword='" + keyword + '\'' +
                ", selected_region='" + selected_region + '\'' +
                '}';
    }
}
