package com.nokia.example.controller;

import com.github.pagehelper.PageInfo;
import com.nokia.example.model.MyBatisModel.UserInfo;
import com.nokia.example.service.MybatisService.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping
    public List<UserInfo> getAll(UserInfo userInfo) {
        List<UserInfo> userInfoList = userInfoService.getAll(userInfo);
        return userInfoList;
    }

    /*@RequestMapping(value = "/add")
    public UserInfo add() {
        return new UserInfo();
    }

    @RequestMapping(value = "/view/{id}")
    public UserInfo view(@PathVariable Integer id) {
        ModelAndView result = new ModelAndView();
        UserInfo userInfo = userInfoService.getById(id);
        return userInfo;
    }*/


}
