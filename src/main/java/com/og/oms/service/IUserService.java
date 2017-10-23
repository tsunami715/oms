package com.og.oms.service;

import com.baomidou.mybatisplus.service.IService;
import com.og.oms.model.User;

import java.util.List;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author jeff
 * @since 2017-10-17
 */
public interface IUserService extends IService<User> {
    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 通过id获取user对象
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);


    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改角色
     *
     * @param user   操作者
     * @param target 被修改者
     * @return
     */
    boolean updateUser(User user, User target);
}
