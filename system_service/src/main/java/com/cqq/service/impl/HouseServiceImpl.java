package com.cqq.service.impl;

import com.cqq.dao.HouseDao;
import com.cqq.domain.House;
import com.cqq.service.HouseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseDao houseDao;

    @Override
    public List<House> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return houseDao.findAll();
    }
}
