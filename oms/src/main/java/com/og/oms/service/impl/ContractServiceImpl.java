package com.og.oms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.og.oms.common.Context;
import com.og.oms.dao.ContractMapper;
import com.og.oms.model.Contract;
import com.og.oms.model.User;
import com.og.oms.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 合同资料服务实现类
 * </p>
 *
 * @author jeff
 * @since 2017-10-15
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    /**
     * 系统上下文
     */
    @Autowired
    private Context context;

    @Override
    public List<Object> getContractList() {
        EntityWrapper wrapper = new EntityWrapper();
        return this.selectList(wrapper);
    }

    @Override
    public Contract getContractById(Integer id) {
        return this.selectById(id);
    }

    @Override
    public boolean addContract(User user, Contract contract) {
        contract.setCreateTime(new Date());
        contract.setCreateUser(user.getAccount());
        return this.insert(contract);
    }

    @Override
    public boolean updateContract(User user, Contract contract) {
        contract.setUpdateTime(new Date());
        contract.setUpdateUser(user.getAccount());
        return this.updateById(contract);
    }

    @Override
    public boolean delContract(User user, Integer id) {
        return this.deleteById(id);
    }

    private Map<String, Object> buildContract(Contract contract) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

        Map<String, Object> map = new HashMap<>();
//        map.put("id", contract.getId());
//        map.put("type", StatusType.getEnumByCode(contract.getType()).getText());
//        map.put("path", contract.getPath());
//        map.put("startTime", simpleDateFormat.format(contract.getStartTime()));
//        map.put("endTime", simpleDateFormat.format(contract.getEndTime()));
//        map.put("signatureCompany", contract.getSignatureCompany());
//        map.put("signaturePerson", contract.getSignaturePerson());
//        map.put("remark", contract.getRemark());

        return map;
    }
}
