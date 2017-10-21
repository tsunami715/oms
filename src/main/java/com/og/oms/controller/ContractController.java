package com.og.oms.controller;

import com.og.oms.enums.ResultCode;
import com.og.oms.model.Contract;
import com.og.oms.service.IContractService;
import com.og.oms.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 合同资料前端控制器
 * </p>
 *
 * @author jeff
 * @since 2017-10-15
 */
@RestController
@RequestMapping("contract")
@SessionAttributes(names = "userId", types = Integer.class)
public class ContractController extends BaseController {
    /**
     * 合同资料服务类
     */
    @Autowired
    private IContractService contractService;

    /**
     * 分页获取合同列表
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public JsonResult getContractList() {
        //        return contractService.selectPage(dtp.getPage());
        return new JsonResult(contractService.selectList(null));
    }

    /**
     * 通过id获取合同信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getContractById(@PathVariable Integer id) {
        return new JsonResult(contractService.getContractById(id));
    }

    /**
     * 添加合同
     *
     * @param userId
     * @param contract
     * @param result
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public JsonResult addContract(@ModelAttribute("userId") Integer userId, @Valid Contract contract, BindingResult result) {
        JsonResult ret;
        if(contractService.addContract(this.getUser(userId), contract)) {
            ret = new JsonResult();
        } else {
            ret = new JsonResult(ResultCode.EXCEPTION);
        }
        return ret;
    }

    /**
     * 修改合同
     *
     * @param userId
     * @param contract
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult updateContract(@ModelAttribute("userId") Integer userId, @Valid Contract contract) {
        JsonResult ret;
        if(contractService.updateContract(this.getUser(userId), contract)) {
            ret = new JsonResult();
        } else {
            ret = new JsonResult(ResultCode.EXCEPTION);
        }
        return ret;
    }

    /**
     * 删除合同
     *
     * @param userId
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public JsonResult delContract(@ModelAttribute("userId") Integer userId, @PathVariable Integer id) {
        JsonResult ret;
        if(contractService.delContract(this.getUser(userId), id)) {
            ret = new JsonResult();
        } else {
            ret = new JsonResult(ResultCode.EXCEPTION);
        }
        return ret;
    }

    /**
     * 获取合同类型用于下拉列表展示
     *
     * @return
     */
    @RequestMapping(value = "select", method = RequestMethod.GET)
    public JsonResult getContractType() {
        return new JsonResult(contractService.getContractType());
    }
}
