package club.kwcoder.server.service.impl;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dataobject.UserDO;
import club.kwcoder.server.dto.UserDTO;
import club.kwcoder.server.mapper.UserMapper;
import club.kwcoder.server.service.UserLoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultBean<String> login(UserDTO user) {
        UserDO userDO = userMapper.selectByPrimaryKey(user.getEmail());
        if (StringUtils.equals(userDO.getPassword(), DigestUtils.md5DigestAsHex((userDO.getSalt() + user.getPassword()).getBytes()))) {
            return ResultBean.getSuccess("登录成功！", null);
        }
        return ResultBean.getForbid("账号或密码错误，请检查后重试！");
    }
}
