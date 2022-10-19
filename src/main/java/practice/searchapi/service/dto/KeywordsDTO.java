package practice.searchapi.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KeywordsDTO {

    private int totalCount;

    private List<KeywordDTO> keywordDTO;

    public KeywordsDTO() {
        this.totalCount = 0;
    }

    public KeywordsDTO(List<KeywordDTO> keywordDTO) {
        this.keywordDTO = keywordDTO;
        this.totalCount = keywordDTO.size();
    }
}
