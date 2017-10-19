package com.og.oms.controller;

import com.og.oms.common.Context;
import com.og.oms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private Context context;

    @RequestMapping("login")
    public void login(HttpServletRequest req, String account) {
        User user = new User();
        user.setId(3);
        user.setAccount(account);
        context.addUser(user);
        req.getSession().setAttribute("userId", user.getId());
    }
}
