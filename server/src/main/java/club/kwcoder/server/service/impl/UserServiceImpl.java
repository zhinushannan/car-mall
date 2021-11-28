package club.kwcoder.server.service.impl;

import club.kwcoder.server.bean.PageBean;
import club.kwcoder.server.dataobject.UserDO;
import club.kwcoder.server.dataobject.UserDOExample;
import club.kwcoder.server.dto.UserDTO;
import club.kwcoder.server.mapper.UserMapper;
import club.kwcoder.server.service.UserService;
import club.kwcoder.server.utils.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void list(PageBean<UserDTO> page) {
        PageHelper.startPage(page.getPage(), page.getSize());

        List<UserDO> userDOS = userMapper.selectByExample(new UserDOExample());
        PageInfo<UserDO> pageInfo = PageInfo.of(userDOS);
        List<UserDTO> userDTOS = CopyUtil.copyList(userDOS, UserDTO.class);
        page
                .setTotal(pageInfo.getTotal())
                .setData(userDTOS);
    }

    @Override
    public void resetPassword(String email) {
        UserDO user = userMapper.selectByPrimaryKey(email);
        String salt = UUID.randomUUID().toString();
        String password = DigestUtils.md5DigestAsHex((salt + email).getBytes());
        user
                .setSalt(salt)
                .setPassword(password)
                .setModifiedGmt(LocalDateTime.now());
        userMapper.updateByPrimaryKey(user);
    }
}
