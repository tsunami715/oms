package com.og.oms.common;

import com.og.oms.enums.ContractType;
import com.og.oms.model.User;
import com.og.oms.service.IProducerService;
import com.og.oms.service.IUserService;
import com.og.oms.utils.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Context {

    @Autowired
    private IUserService userService;

    @Autowired
    private IProducerService producerService;


    private ConcurrentHashMap<Integer, User> userMap = new ConcurrentHashMap();


    @PostConstruct
    private void init() {
        // 初始化供应商枚举
        producerService.initProducerEnum();

        initDynamicEnums();
    }

    public void initDynamicEnums() {
        EnumUtil.addEnum(ContractType.class, "d", new Class[]{Integer.class, String.class}, new Object[]{1, "测试1"});
        EnumUtil.addEnum(ContractType.class, "d", new Class[]{Integer.class, String.class}, new Object[]{2, "测试2"});
        EnumUtil.addEnum(ContractType.class, "d", new Class[]{Integer.class, String.class}, new Object[]{3, "测试3"});
        EnumUtil.addEnum(ContractType.class, "e", new Class[]{Integer.class, String.class}, new Object[]{4, "测试4"});
        EnumUtil.addEnum(ContractType.class, "f", new Class[]{Integer.class, String.class}, new Object[]{5, "测试5"});
    }

    /**
     * 增加用户到内存
     *
     * @param user
     */
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    /**
     * 通过id获取用户对象
     *
     * @param userId
     * @return
     */
    public User getUserById(Integer userId) {
        User user = userMap.get(userId);
        if(user == null) {
            user = this.userService.selectById(userId);
        }
        return user;
    }
}
