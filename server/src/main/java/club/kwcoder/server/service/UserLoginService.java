package club.kwcoder.server.service;

import club.kwcoder.server.bean.ResultBean;
import club.kwcoder.server.dto.UserDTO;

import javax.servlet.http.HttpServletResponse;

public interface UserLoginService {

    ResultBean<String> login(UserDTO user);

    void logout(String email, HttpServletResponse response);

}
