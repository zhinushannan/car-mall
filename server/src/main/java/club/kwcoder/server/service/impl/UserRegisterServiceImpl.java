package club.kwcoder.server.service.impl;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dataobject.UserDO;
import club.kwcoder.server.dto.UserDTO;
import club.kwcoder.server.mapper.UserMapper;
import club.kwcoder.server.service.UserRegisterService;
import club.kwcoder.server.utils.CodeUtil;
import club.kwcoder.server.utils.EmailUtil;
import club.kwcoder.server.utils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean sendCode(String email) {
        String code = CodeUtil.getCode();
        try {
            emailUtil.send(email, "注册验证码", "您好，您本次的注册验证码为：" + code + "，请不要将此验证码转发给别人，验证码五分钟有效.");
            redisUtil.setString("code:" + email, code, 5, TimeUnit.MINUTES);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean hasRegistered(String email) {
        return null != userMapper.selectByPrimaryKey(email);
    }

    @Override
    public ResultBean<String> register(UserDTO user) {
        if (user.isPasswordEqualRepeat() || user.isEmailLegal()) {
            return ResultBean.getForbid("参数错误！");
        }
        if (this.hasRegistered(user.getEmail())) {
            return ResultBean.getForbid("该邮箱已被注册！");
        }
        if (StringUtils.equals(user.getCode(), redisUtil.getString("code:" + user.getEmail()))) {
            UserDO userDO = this.getUserDO(user);
            userMapper.insert(userDO);
            return ResultBean.getSuccess("注册成功！", null);
        }
        return ResultBean.getForbid("验证码错误或已失效，请检查后重新注册！");
    }

    @Override
    public ResultBean<String> changePassword(UserDTO user) {
        if (user.isPasswordEqualRepeat() || user.isEmailLegal()) {
            return ResultBean.getForbid("参数错误！");
        }

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
