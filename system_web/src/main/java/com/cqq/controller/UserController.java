package com.cqq.controller;

import com.cqq.dao.UserDao;
import com.cqq.domain.Role;
import com.cqq.domain.UserInfo;
import com.cqq.service.RoleService;
import com.cqq.service.UserService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 分页查询所有的用户
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(int page, int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 新建用户，并添加普通用户角色，将用户的类型设为普通用户
     * @param userInfo
     * @return
     */
    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userInfo.setUserType(0);
        userService.saveUser(userInfo);
        UserInfo user = userService.findByUsername(userInfo.getUsername());
        roleService.addRoleToUser(user.getId(),2);
        return "redirect:findAll?page=1&size=5";
    }

    /**
     * 根据用户的id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("findById")
    public ModelAndView findById(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(int id) throws Exception{
        userService.delete(id);
        return "redirect:findAll?page=1&size=5";
    }

    /**
     *  根据用户的id查询用户和用户所没有的角色
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndOtherRole")
    public ModelAndView findUserByIdAndOtherRole(int userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(userId);
        List<Role> roles = roleService.findOtherRole(userId);
        mv.addObject("user",user);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 根据用户id 和 角色的id数组，将角色添加到用户身上，底层操作user_role表，添加一条记录
     * @param userId
     * @param roleIds
     * @return
     * @throws Exception
     */
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(int userId, int[] roleIds) throws Exception {
        for(int roleId : roleIds){
            if(roleId == 1){
                //如果是管理员角色的话将用户的类型从普通用户变更为管理员
                userService.findById(userId).setUserType(1);
            }
            roleService.addRoleToUser(userId,roleId);
        }
        return "redirect:findById?id="+userId;
    }

    @ResponseBody
    @RequestMapping("/findUserByUsername")
    UserInfo findUserByUsername(String username){
        UserInfo user = userService.findByUsername(username);
        return user;
    }

    @RequestMapping("/register")
    public String register(UserInfo userInfo){
        userService.saveUser(userInfo);
        return "redirect:/doregister.jsp";
    }
}
