package practice.searchapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.searchapi.entity.Keyword;
import practice.searchapi.entity.repository.KeywordRepository;

@Service
@RequiredArgsConstructor
public class KeywordCommandService {

    private final KeywordRepository keywordRepository;

    public void countKeyword(String query) {
        // test 커밋
        Keyword keyword = keywordRepository.findByName(query)
                                           .orElse(new Keyword(query));
        keyword.counted();
        keywordRepository.save(keyword);
    }
}
