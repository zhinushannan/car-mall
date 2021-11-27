package club.kwcoder.server.service.impl;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dataobject.UserDO;
import club.kwcoder.server.dto.UserDTO;
import club.kwcoder.server.mapper.UserMapper;
import club.kwcoder.server.service.UserRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean hasRegistered(String email) {
        return null != userMapper.selectByPrimaryKey(email);
    }

    @Override
    public void register(UserDTO user) {
        UserDO userDO = this.getUserDO(user);
        userMapper.insert(userDO);
    }

    @Override
    public ResultBean<String> changePassword(UserDTO user) {
        UserDO userDO = userMapper.selectByPrimaryKey(user.getEmail());

        user.setSalt(userDO.getSalt());

        if (!user.isPasswordCorrect(userDO.getPassword())) {
            return ResultBean.getForbid("原密码错误！");
        }

        BeanUtils.copyProperties(user, userDO);
        userDO = this.getUserDO(user);
        userMapper.updateByPrimaryKey(userDO);
        return ResultBean.getSuccess("密码修改成功！", null);
    }

    private UserDO getUserDO(UserDTO user) {
        UserDO userDO = new UserDO();
        String salt = UUID.randomUUID().toString();
        String password = DigestUtils.md5DigestAsHex((salt + user.getPassword()).getBytes());
        userDO
                .setEmail(user.getEmail())
                .setSalt(salt)
                .setPassword(password);
        if (null == user.getCreatedGmt()) {
            LocalDateTime now = LocalDateTime.now();
            userDO
                    .setCreatedGmt(now)
                    .setModifiedGmt(now)
                    .setLastLogin(now);
        }
        return userDO;
    }
}
