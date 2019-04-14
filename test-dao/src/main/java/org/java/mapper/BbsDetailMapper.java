package org.java.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.pojo.BbsDetail;
import org.java.pojo.BbsDetailExample;

import java.util.List;
@Mapper
public interface BbsDetailMapper {
    int countByExample(BbsDetailExample example);

    int deleteByExample(BbsDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BbsDetail record);

    int insertSelective(BbsDetail record);

    List<BbsDetail> selectByExample(BbsDetailExample example);

    BbsDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BbsDetail record, @Param("example") BbsDetailExample example);

    int updateByExample(@Param("record") BbsDetail record, @Param("example") BbsDetailExample example);

    int updateByPrimaryKeySelective(BbsDetail record);

    int updateByPrimaryKey(BbsDetail record);
}