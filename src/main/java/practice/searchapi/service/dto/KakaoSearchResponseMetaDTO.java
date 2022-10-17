package practice.searchapi.service.dto;

public class KakaoSearchResponseMetaDTO {

    private int totalCount;

    private int pageable_count;

    private boolean is_end;

    private KakaoSearchResponseMetaRegionInfo same_name;

    @Override
    public String toString() {
        return "KakaoSearchResponseMetaDTO{" +
                "totalCount=" + totalCount +
                ", pageable_count=" + pageable_count +
                ", is_end=" + is_end +
                ", same_name=" + same_name +
                '}';
    }
}
