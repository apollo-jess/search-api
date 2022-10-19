package practice.searchapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.searchapi.service.KeywordQueryService;
import practice.searchapi.service.dto.KeywordsDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/keywords")
public class KeywordController {

    private final KeywordQueryService keywordQueryService;

    @GetMapping("/top10")
    public ResponseEntity<KeywordsDTO> getKeywordTop10List() {
        return ResponseEntity.ok(keywordQueryService.getKeywordList());
    }
}
