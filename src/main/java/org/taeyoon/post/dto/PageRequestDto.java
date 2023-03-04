package org.taeyoon.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDto {

    // 화면에서 전달되는 page라는 파라미터와 size라는 파라미터를 수집하는 역할
    // 진짜 목적은 JPA에서 사용되는 Pageable 타입의 객체를 생성하는 것

    private int page;
    private int size;

    public PageRequestDto() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}
