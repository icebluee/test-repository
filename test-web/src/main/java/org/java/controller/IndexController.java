package org.java.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.java.pojo.BbsDetail;
import org.java.service.BbsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class IndexController {

    @Reference
    private BbsService bbsService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("/addList")
    public String addList(BbsDetail bbsDetail, Model model){
        //执行添加
        bbsDetail.setCraetedate(new Date());
        try {
            Integer row = bbsService.addDetail(bbsDetail);
            model.addAttribute("msg","true");
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg","false");
        }
        //添加成功返回页面
        return "index";
    }

}
