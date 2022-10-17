package practice.searchapi.service.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
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
