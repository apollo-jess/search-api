package practice.searchapi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KeywordDTO {

    private String name;

    private Long count;
}
