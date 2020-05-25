package com.zzk.atcrowdfunding.mvc.handler;


import com.zzk.atcrowdfunding.entity.Admin;
import com.zzk.atcrowdfunding.entity.Student;
import com.zzk.atcrowdfunding.service.api.AdminService;
import com.zzk.atcrowdfunding.util.CrowdUtil;
import com.zzk.atcrowdfunding.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestHandler {

    private Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @Autowired
    private AdminService adminService;


    @ResponseBody
    @RequestMapping("/send/student/three.json")
    public ResultEntity<Student> testReceiveComposeSubject(@RequestBody Student student, HttpServletRequest request){
        boolean type = CrowdUtil.judgeRequestType(request);
        logger.info("type={}",type);
        String a = null;
        System.out.println(a.length());
        logger.info("stundet:{}",student);
        ResultEntity<Student> resultEntity = ResultEntity.successWithData(student);
        return resultEntity;
    }


    @ResponseBody
    @RequestMapping("/send/array/two.html")
    public String testReceiverTwo(@RequestBody List<Integer> array){
        for (Integer integer : array) {
            logger.info("number={}",integer);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/array.html")
    public String testReceiver(@RequestParam("array[]") List<Integer> array){
        for (Integer integer : array) {
            System.out.println(integer);
        }
        return "success";
    }


    @RequestMapping("/test/ssm.html")
    public String test(ModelMap modelMap, HttpServletRequest request){
        boolean type = CrowdUtil.judgeRequestType(request);
        logger.info("type={}",type);

        String a = null;
        System.out.println(a.length());

        List<Admin> all = adminService.getAll();

        modelMap.addAttribute("all", all);
        return "target";
    }
}
