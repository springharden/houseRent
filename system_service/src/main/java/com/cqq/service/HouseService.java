package com.cqq.service;

import com.cqq.domain.House;

import java.util.List;

public interface HouseService {

    List<House> findAll(int page, int size) throws Exception;
}
