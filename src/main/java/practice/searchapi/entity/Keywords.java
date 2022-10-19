package practice.searchapi.entity;

import practice.searchapi.service.dto.KeywordDTO;
import practice.searchapi.service.dto.KeywordsDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Keywords {

    private final List<Keyword> keywords;

    public Keywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public KeywordsDTO toDTO() {
        List<KeywordDTO> keywordDTOs = this.keywords.stream()
                .map(Keyword::toDTO)
                .collect(Collectors.toList());

        return new KeywordsDTO(keywordDTOs);
    }
}
