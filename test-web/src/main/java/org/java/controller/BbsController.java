package org.java.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.java.pojo.BbsDetail;
import org.java.pojo.BbsSort;
import org.java.service.BbsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BbsController {
    //

    @Reference
    private BbsService bbsService;

    @RequestMapping(value = "/show",method = RequestMethod.POST)
    public List<BbsDetail> getAllBySortId(@RequestParam(name = "sortId",defaultValue = "-1",required = false)Long sortId) {
        List<BbsDetail> bbsDetails = bbsService.queryAllBySortId(sortId);
        return bbsDetails;
    }

    @RequestMapping(value = "/getSortList")
    public List<BbsSort> getSortList(){
        return bbsService.querySorts();
    }




}
