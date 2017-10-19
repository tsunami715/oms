package com.og.oms.service;

import com.baomidou.mybatisplus.service.IService;
import com.og.oms.model.Contract;
import com.og.oms.model.User;

import java.util.List;

/**
 * <p>
 * 合同资料服务类
 * </p>
 *
 * @author jeff
 * @since 2017-10-15
 */
public interface IContractService extends IService<Contract> {

    /**
     * 获取合同列表
     *
     * @return
     */
    List<Object> getContractList();

    /**
     * 通过id获取合同信息
     *
     * @param id
     * @return
     */
    Contract getContractById(Integer id);

    /**
     * 添加合同资料
     *
     * @param user
     * @param contract
     * @return
     */
    boolean addContract(User user, Contract contract);

    /**
     * 修改合同资料
     *
     * @param user
     * @param contract
     * @return
     */
    boolean updateContract(User user, Contract contract);

    /**
     * 删除合同资料
     * @param user
     * @param id
     * @return
     */
    boolean delContract(User user, Integer id);
}
