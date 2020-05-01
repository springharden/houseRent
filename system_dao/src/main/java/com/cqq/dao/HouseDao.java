package com.cqq.dao;

import com.cqq.domain.House;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HouseDao {

    @Select("select * from house")
    List<House> findAll() throws Exception;
}
