package com.og.oms.controller;

import com.og.oms.service.IContractService;
import com.og.oms.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IProducerService producerService;

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "index")
    public ModelAndView indexPage(ModelAndView model) {
        return model;
    }

    /**
     * 欢迎页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "welcome")
    public ModelAndView welcomePage(ModelAndView model) {
        return model;
    }

    /**
     * 管理员列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "admin-list")
    public ModelAndView adminListPage(ModelAndView model) {
        return model;
    }

    /**
     * 权限组列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "group-list")
    public ModelAndView groupListPage(ModelAndView model) {
        return model;
    }

    /**
     * 合同列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "contract-list")
    public ModelAndView contractListPage(ModelAndView model) {
        return model;
    }

    /**
     * 合同详细页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "contract-info")
    public ModelAndView contractInfoPage(ModelAndView model) {
        model.addObject("contractType", contractService.getContractType());
        return model;
    }

    /**
     * 服务器列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "server-list")
    public ModelAndView serverListPage(ModelAndView model) {
        return model;
    }

    /**
     * 域名列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "domain-list")
    public ModelAndView domainListPage(ModelAndView model) {
        return model;
    }

    /**
     * 供应商列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "producer-list")
    public ModelAndView producerListPage(ModelAndView model) {
        return model;
    }

    /**
     * 联系人列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "linkman-list")
    public ModelAndView linkmanListPage(ModelAndView model) {
        return model;
    }

    /**
     * 机房列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "serverroom-list")
    public ModelAndView serverroomListPage(ModelAndView model) {
        return model;
    }

    /**
     * 网设列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "devices-list")
    public ModelAndView devicesListPage(ModelAndView model) {
        return model;
    }

    /**
     * 线路列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "network-list")
    public ModelAndView networkListPage(ModelAndView model) {
        return model;
    }

    /**
     * 站点列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "station-list")
    public ModelAndView stationListPage(ModelAndView model) {
        return model;
    }

    /**
     * 系统字典列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "system-data")
    public ModelAndView dataListPage(ModelAndView model) {
        return model;
    }
}
