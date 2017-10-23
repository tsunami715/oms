package com.og.oms.controller;

import com.og.oms.service.IUserService;
import com.og.oms.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@RestController
@RequestMapping(value = "user")
@SessionAttributes(names = "userId", types = Integer.class)
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public JsonResult getUserList(Integer type1, Integer type2, Integer type3, Date datemin, Date datemax) {
        return new JsonResult(userService.getUserList());
    }
}
