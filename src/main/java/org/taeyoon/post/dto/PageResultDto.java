package org.taeyoon.post.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class PageResultDto<DTO, EN> {
    // Page<Entity> 객체를 DTO 객체로 변환해서 자료구조에 담아준다.
    // 화면 출력에 필요한 페이지 정보들을 구성한다.
    private List<DTO> dtoList;

    public PageResultDto(Page<EN> result, Function<EN, DTO> fn) {
        // fn -> 엔티티를 DTO로 변환해주는 기능
        dtoList = result.stream().map(fn).collect(Collectors.toList());
    }

    // Page<Entity> 내용물 중에서 엔티티 객체를 DTO로 변환해주는 기능이 필요하다.
    // 이 책에서 엔티티 객체의 DTO 변환은 서비스 인터페이스에서 정의한 메소드 entityToDto()와 별도의 Function 객체로 만들어서 처리한다.
}
