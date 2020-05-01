package com.cqq.controller;

import com.cqq.domain.House;
import com.cqq.service.HouseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    /**
     * 分页查询所有的房源信息
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(int page, int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<House> list = houseService.findAll(page, size);
        PageInfo housePageInfo = new PageInfo(list);
        mv.addObject("housePageInfo",housePageInfo);
        mv.setViewName("house-list");
        return mv;
    }
}
