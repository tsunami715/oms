package com.og.oms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.og.oms.dao.ProducerMapper;
import com.og.oms.enums.ProducerEnum;
import com.og.oms.model.Producer;
import com.og.oms.model.User;
import com.og.oms.service.IProducerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jeff
 * @since 2017-10-17
 */
@Service
public class ProducerServiceImpl extends ServiceImpl<ProducerMapper, Producer> implements IProducerService {

    @Override
    public List<Producer> getProducerList() {
        EntityWrapper<Producer> wrapper = new EntityWrapper();
        return this.selectList(wrapper);
    }

    @Override
    public Producer getProducerById(Integer id) {
        return this.selectById(id);
    }

    @Override
    public boolean addProducer(User user, Producer producer) {
        // 保存供应商信息
        boolean ret = this.insert(producer);

        // TODO 保存联系人什么的

        // 增加供应商枚举
        ProducerEnum.addEnum(producer.getId(), producer.getName());
        return ret;
    }

    @Override
    public boolean updateProducer(User user, Producer producer) {
        boolean ret = this.updateById(producer);
        this.updateProducerEnum(producer);
        return ret;
    }

    @Override
    public boolean delProducer(User user, Integer id) {
        return this.deleteById(id);
    }

    @Override
    public Map<Integer, String> getProducerType() {
        Map<Integer, String> map = new HashMap<>(ProducerEnum.values().length);
        for(ProducerEnum producerEnum : ProducerEnum.values()) {
            map.put(producerEnum.getCode(), producerEnum.getName());
        }
        return map;
    }

    @Override
    public void initProducerEnum() {
        for(Producer producer : this.selectList(null)) {
            ProducerEnum.addEnum(producer.getId(), producer.getName());
        }
    }

    /**
     * 修改供应商枚举
     *
     * @param producer
     */
    private void updateProducerEnum(Producer producer) {
        for(ProducerEnum anEnum : ProducerEnum.values()) {
            if(anEnum.getCode() == producer.getId()) {
                anEnum.setName(producer.getName());
                break;
            }
        }
    }
}
