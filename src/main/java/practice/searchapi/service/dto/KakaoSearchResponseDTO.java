package practice.searchapi.service.dto;

import java.util.List;

public class KakaoSearchResponseDTO {

    private KakaoSearchResponseMetaDTO meta;

    private List<KakaoSearchResponseDocumentsDTO> documents;

    @Override
    public String toString() {
        return "KakaoSearchResponseDTO{" +
                "meta=" + meta +
                ", documents=" + documents +
                '}';
    }
}
