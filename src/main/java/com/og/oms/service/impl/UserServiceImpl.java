package com.og.oms.service.impl;

import com.og.oms.model.User;
import com.og.oms.dao.UserMapper;
import com.og.oms.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeff
 * @since 2017-10-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<User> getUserList() {
        return this.selectList(null);
    }

    @Override
    public User getUserById(Integer id) {
        return this.selectById(id);
    }

    @Override
    public boolean addUser(User user) {
        user.setCreateTime(new Date());
        user.setCreateUser("system");
        return this.insert(user);
    }

    @Override
    public boolean updateUser(User user, User target) {
        target.setUpdateUser(user.getAccount());
        target.setUpdateTime(new Date());
        return this.updateById(target);
    }
}
