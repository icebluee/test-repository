package org.java.service;

import org.java.pojo.BbsDetail;
import org.java.pojo.BbsSort;

import java.util.List;

public interface BbsService {

    List<BbsDetail> queryAll();

    List<BbsDetail> queryAllBySortId(Long sortId);

    Integer addDetail(BbsDetail bbsDetail);

    List<BbsSort> querySorts();

}
