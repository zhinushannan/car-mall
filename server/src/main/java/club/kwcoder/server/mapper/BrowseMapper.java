package club.kwcoder.server.mapper;

import club.kwcoder.server.dataobject.BrowseDO;
import club.kwcoder.server.dataobject.BrowseDOExample;
import club.kwcoder.server.dataobject.BrowseDOKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrowseMapper {
    long countByExample(BrowseDOExample example);

    int deleteByExample(BrowseDOExample example);

    int deleteByPrimaryKey(BrowseDOKey key);

    int insert(BrowseDO record);

    int insertSelective(BrowseDO record);

    List<BrowseDO> selectByExample(BrowseDOExample example);

    BrowseDO selectByPrimaryKey(BrowseDOKey key);

    int updateByExampleSelective(@Param("record") BrowseDO record, @Param("example") BrowseDOExample example);

    int updateByExample(@Param("record") BrowseDO record, @Param("example") BrowseDOExample example);

    int updateByPrimaryKeySelective(BrowseDO record);

    int updateByPrimaryKey(BrowseDO record);
}