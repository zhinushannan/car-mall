package club.kwcoder.server.mapper;

import club.kwcoder.server.dataobject.UserDO;
import club.kwcoder.server.dataobject.UserDOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    long countByExample(UserDOExample example);

    int deleteByExample(UserDOExample example);

    int deleteByPrimaryKey(String email);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    /**
     * 通过此方法查询的用户信息不显示盐和密码
     * @param example example
     * @return 返回用户信息列表
     */
    List<UserDO> selectByExample(UserDOExample example);

    /**
     * 通过此方法查询的用户信息显示盐和密码
     * @param email 用户的email
     * @return 返回用户信息
     */
    UserDO selectByPrimaryKey(String email);

    int updateByExampleSelective(@Param("record") UserDO record, @Param("example") UserDOExample example);

    int updateByExample(@Param("record") UserDO record, @Param("example") UserDOExample example);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}