package com.self.university_structure.service;

import com.self.university_structure.dto.ResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface BaseService<T, L> {
    ResponseDto<Long> create(L l);
    @Transactional
    ResponseDto<T> getById(Long id);
    ResponseDto<Long> update(L l);
    ResponseDto<Long> delete(Long id);
}
