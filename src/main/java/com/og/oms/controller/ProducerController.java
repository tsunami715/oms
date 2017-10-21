package com.og.oms.controller;

import com.og.oms.enums.ResultCode;
import com.og.oms.model.Producer;
import com.og.oms.service.IProducerService;
import com.og.oms.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * <p>
 * 供应商前端控制器
 * </p>
 *
 * @author jeff
 * @since 2017-10-17
 */
@Controller
@RequestMapping("producer")
public class ProducerController extends BaseController {
    /**
     * 供应商资料服务类
     */
    @Autowired
    private IProducerService producerService;

    /**
     * 分页获取供应商列表
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public JsonResult getProducerList() {
        return new JsonResult(producerService.getProducerList());
    }

    /**
     * 通过id获取供应商信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getProducerById(@PathVariable Integer id) {
        return new JsonResult(producerService.getProducerById(id));
    }

    /**
     * 添加供应商
     *
     * @param userId
     * @param producer
     * @param result
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public JsonResult addContract(@ModelAttribute("userId") Integer userId, @Valid Producer producer, BindingResult result) {
        JsonResult ret;
        if(producerService.addProducer(this.getUser(userId), producer)) {
            ret = new JsonResult();
        } else {
            ret = new JsonResult(ResultCode.EXCEPTION);
        }
        return ret;
    }

    /**
     * 修改供应商
     *
     * @param userId
     * @param producer
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult updateContract(@ModelAttribute("userId") Integer userId, @Valid Producer producer) {
        JsonResult ret;
        if(producerService.updateProducer(this.getUser(userId), producer)) {
            ret = new JsonResult();
        } else {
            ret = new JsonResult(ResultCode.EXCEPTION);
        }
        return ret;
    }

    /**
     * 删除供应商
     *
     * @param userId
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public JsonResult delContract(@ModelAttribute("userId") Integer userId, @PathVariable Integer id) {
        JsonResult ret;
        if(producerService.delProducer(this.getUser(userId), id)) {
            ret = new JsonResult();
        } else {
            ret = new JsonResult(ResultCode.EXCEPTION);
        }
        return ret;
    }
}
