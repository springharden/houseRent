package com.cqq.controller;

import com.cqq.domain.Role;
import com.cqq.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(int page, int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll(page, size);
        PageInfo rolePageInfo = new PageInfo(roleList);
        mv.addObject("rolePageInfo",rolePageInfo);
        mv.setViewName("role-list");
        return mv;
    }
}
