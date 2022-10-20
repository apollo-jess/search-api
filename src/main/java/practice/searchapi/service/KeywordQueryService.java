package practice.searchapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.searchapi.entity.Keyword;
import practice.searchapi.entity.Keywords;
import practice.searchapi.entity.repository.KeywordRepository;
import practice.searchapi.service.dto.KeywordsDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KeywordQueryService {

    private final KeywordRepository keywordRepository;

    public KeywordsDTO getKeywordList() {
        List<Keyword> keywordsTop10 = keywordRepository.findTop10ByOrderByCountDesc().orElse(null);
        if (keywordsTop10 == null) {
            return new KeywordsDTO();
        }

        Keywords keywords = new Keywords(keywordsTop10);
        return keywords.toDTO();
    }
}
