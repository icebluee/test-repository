package org.java.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.java.mapper.BbsDetailMapper;
import org.java.mapper.BbsSortMapper;
import org.java.pojo.BbsDetail;
import org.java.pojo.BbsDetailExample;
import org.java.pojo.BbsSort;
import org.java.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service       //暴露服务
@Component     //因为没有写xml, 所以要注解交给spring管理
public class BbsServiceImpl implements BbsService{

    @Autowired
    private BbsDetailMapper bbsDetailMapper;
    @Autowired
    private BbsSortMapper bbsSortMapper;

    @Override
    public List<BbsDetail> queryAll() {
        List<BbsDetail> bbsDetails = bbsDetailMapper.selectByExample(null);
        return bbsDetails;
    }

    @Override
    public List<BbsDetail> queryAllBySortId(Long sortId) {
        BbsDetailExample example = new BbsDetailExample();

        BbsDetailExample.Criteria criteria = example.createCriteria();
        //添加条件查询中的条件.
        if (sortId != null && sortId != -1){
            criteria.andSortidEqualTo(sortId);
        }
        //执行
        List<BbsDetail> bbsDetails = bbsDetailMapper.selectByExample(example);
        return bbsDetails;
    }

    @Override
    public List<BbsSort> querySorts() {
        return bbsSortMapper.selectByExample(null);
    }

    @Override
    public Integer addDetail(BbsDetail bbsDetail) {
        int row = bbsDetailMapper.insertSelective(bbsDetail);
        return row;
    }

}
