package com.self.university_structure.service;

import com.self.university_structure.dto.ResponseDto;

public interface BaseService<T> {
    ResponseDto<Long> create(T t);
    ResponseDto<T> getById(Long id);
    ResponseDto<Long> update(T t);
    ResponseDto<Long> delete(Long id);
}
