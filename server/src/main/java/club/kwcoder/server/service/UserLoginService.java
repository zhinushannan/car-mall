package club.kwcoder.server.service;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.UserDTO;

public interface UserLoginService {

    ResultBean<String> login(UserDTO user);

}
