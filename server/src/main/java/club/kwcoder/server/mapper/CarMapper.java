package club.kwcoder.server.mapper;

import club.kwcoder.server.dataobject.CarDO;
import club.kwcoder.server.dataobject.CarDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CarMapper {
    long countByExample(CarDOExample example);

    int deleteByExample(CarDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(CarDO record);

    int insertSelective(CarDO record);

    List<CarDO> selectByExample(CarDOExample example);

    CarDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CarDO record, @Param("example") CarDOExample example);

    int updateByExample(@Param("record") CarDO record, @Param("example") CarDOExample example);

    int updateByPrimaryKeySelective(CarDO record);

    int updateByPrimaryKey(CarDO record);
}