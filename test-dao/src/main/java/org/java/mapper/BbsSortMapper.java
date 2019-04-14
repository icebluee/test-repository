package org.java.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.pojo.BbsSort;
import org.java.pojo.BbsSortExample;

import java.util.List;
@Mapper
public interface BbsSortMapper {
    int countByExample(BbsSortExample example);

    int deleteByExample(BbsSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BbsSort record);

    int insertSelective(BbsSort record);

    List<BbsSort> selectByExample(BbsSortExample example);

    BbsSort selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BbsSort record, @Param("example") BbsSortExample example);

    int updateByExample(@Param("record") BbsSort record, @Param("example") BbsSortExample example);

    int updateByPrimaryKeySelective(BbsSort record);

    int updateByPrimaryKey(BbsSort record);
}